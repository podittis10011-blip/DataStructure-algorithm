package DataStructure.JavaCollection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Jdk17CoreMirrorsTest {

    @Test
    void arrayListCoreKeepsJdkStyleLazyFirstGrowthAndTailShift() {
        Jdk17ArrayListCoreMirror<Integer> list = new Jdk17ArrayListCoreMirror<>();
        for (int i = 0; i < 11; i++) list.add(i);
        list.add(1, 99);
        assertEquals(12, list.size());
        assertEquals(99, list.get(1));
        assertEquals(1, list.remove(2));
        assertEquals(2, list.get(2));
    }

    @Test
    void linkedListCoreLinksAndUnlinksBothEndsCorrectly() {
        Jdk17LinkedListCoreMirror<String> list = new Jdk17LinkedListCoreMirror<>();
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals("B", list.remove(1));
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void hashMapCoreUsesCollisionChainAndJdkStyleLowHighResizeSplit() {
        Jdk17HashMapLinearBinsMirror<CollisionKey, String> map = new Jdk17HashMapLinearBinsMirror<>();
        map.put(new CollisionKey("one"), "A");
        map.put(new CollisionKey("two"), "B");
        assertEquals("A", map.get(new CollisionKey("one")));
        assertEquals("A", map.put(new CollisionKey("one"), "A2"));
        assertEquals("A2", map.get(new CollisionKey("one")));

        Jdk17HashMapLinearBinsMirror<Integer, Integer> growing = new Jdk17HashMapLinearBinsMirror<>();
        for (int i = 0; i < 100; i++) growing.put(i, i);
        assertEquals(100, growing.size());
        assertEquals(99, growing.get(99));
        growing.put(null, null);
        assertTrue(growing.containsKey(null));
        assertNull(growing.get(null));
    }

    private record CollisionKey(String value) {
        @Override
        public int hashCode() {
            return 1;
        }
    }
}
