package DataStructure.JavaCollection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Jdk17ConcurrentHashMapCoreMirrorTest {

    @Test
    void putIfAbsentAndNullBoundaryFollowConcurrentHashMapSemantics() {
        Jdk17ConcurrentHashMapCoreMirror<String, Integer> map = new Jdk17ConcurrentHashMapCoreMirror<>();
        assertNull(map.put("java", 17));
        assertEquals(17, map.putIfAbsent("java", 21));
        assertEquals(17, map.get("java"));
        assertThrows(NullPointerException.class, () -> map.put(null, 1));
        assertThrows(NullPointerException.class, () -> map.put("null", null));
    }

    @Test
    void concurrentEmptyBinCasAndCollisionBinLockDoNotLoseMappings() throws Exception {
        int threadCount = 8;
        int entriesPerThread = 100;
        Jdk17ConcurrentHashMapCoreMirror<CollisionKey, Integer> map = new Jdk17ConcurrentHashMapCoreMirror<>();
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch ready = new CountDownLatch(threadCount);
        CountDownLatch start = new CountDownLatch(1);
        List<java.util.concurrent.Future<?>> futures = new ArrayList<>();

        for (int thread = 0; thread < threadCount; thread++) {
            final int offset = thread * entriesPerThread;
            futures.add(pool.submit(() -> {
                ready.countDown();
                start.await();
                for (int i = 0; i < entriesPerThread; i++) {
                    map.put(new CollisionKey(offset + i), offset + i);
                }
                return null;
            }));
        }
        ready.await(3, TimeUnit.SECONDS);
        start.countDown();
        for (java.util.concurrent.Future<?> future : futures) future.get(5, TimeUnit.SECONDS);
        pool.shutdown();
        assertEquals(threadCount * entriesPerThread, map.size());
        assertEquals(799, map.get(new CollisionKey(799)));
    }

    private record CollisionKey(int id) {
        @Override
        public int hashCode() {
            return 1;
        }
    }
}
