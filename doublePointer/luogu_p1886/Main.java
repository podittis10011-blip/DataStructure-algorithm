package doublePointer.luogu_p1886;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// Try01:TLE
public class Main {
    static int n,k;
    static int[] a;

    static Deque<Integer> dq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();k = sc.nextInt();
        a = new int[n + 1];
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }

        dq = new ArrayDeque<Integer>();

        for(int i = 1; i <= n;i++){
            while(!dq.isEmpty() && dq.getFirst() < i - k + 1){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[dq.getLast()] > a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k){
                System.out.print(a[dq.getFirst()] + " ");
            }
        }
        System.out.println();

        dq.clear();

        for(int i = 1; i <= n;i++){
            while(!dq.isEmpty() && dq.getFirst() < i - k + 1){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[dq.getLast()] < a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k){
                System.out.print(a[dq.getFirst()] + " ");
            }
        }
    }
}

/*
 * ==================== TLE 原因分析 & 优化方案 ====================
 *
 * 你的算法逻辑完全正确（单调队列），TLE 有 3 个原因：
 *
 * 【致命 1】Scanner 太慢
 *   Scanner 用正则解析输入，每次 nextInt() 都要正则匹配。
 *   n 最大 10^6，1e6 次调用 → 严重超时。
 *   → 用 BufferedReader + StringTokenizer 替代。
 *
 * 【致命 2】System.out.print 循环中调用百万次
 *   两个循环各输出约 (n-k) 次，合计可到 200 万次 I/O 调用。
 *   每次 print 都是操作系统级调用，极慢。
 *   → 用 StringBuilder 拼接，最后一次性输出。
 *
 * 【致命 3】ArrayDeque<Integer> 自动装箱（次要）
 *   每次 addLast(i) 都把 int 装箱成 Integer 对象。
 *   10^6 次装箱 → 大量临时对象 → 频繁 GC 停顿。
 *   → 用 int[] 手动模拟队列，消除装箱开销。
 *
 * ==================== 优化后的 AC 代码 ====================

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] a;
    // 手写队列：用 int 数组存下标，避免 Integer 装箱
    static int[] q;       // 队列数组
    static int head, tail; // head=队头索引, tail=队尾+1（左闭右开）

    public static void main(String[] args) throws IOException {
        // ----- 优化1: 快读 -----
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n + 1];
        q = new int[n + 5];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // ----- 优化2: StringBuilder 收集答案 -----
        StringBuilder sb = new StringBuilder();

        // ======== 最小值（单调递增队列） ========
        head = 0; tail = 0;  // head == tail 表示队空

        for (int i = 1; i <= n; i++) {
            // 队头淘汰过期：队头下标 < 窗口左边界
            while (head < tail && q[head] < i - k + 1) {
                head++;                   // 等价 pollFirst()
            }
            // 队尾维护单调递增：队尾值 >= a[i] 的弹走
            while (head < tail && a[q[tail - 1]] >= a[i]) {
                tail--;                   // 等价 pollLast()
            }
            q[tail++] = i;                // 等价 offerLast(i)

            if (i >= k) {
                sb.append(a[q[head]]).append(' ');  // 队头=当前窗口最小值
            }
        }
        sb.append('\n');

        // ======== 最大值（单调递减队列） ========
        head = 0; tail = 0;

        for (int i = 1; i <= n; i++) {
            while (head < tail && q[head] < i - k + 1) {
                head++;
            }
            // 队尾维护单调递减：队尾值 <= a[i] 的弹走
            while (head < tail && a[q[tail - 1]] <= a[i]) {
                tail--;
            }
            q[tail++] = i;

            if (i >= k) {
                sb.append(a[q[head]]).append(' ');
            }
        }

        // ----- 一次性全部输出 -----
        System.out.print(sb);
    }
}

 * ==================== 对照表 ====================
 *
 *   操作          C++ deque        Java Deque          手动 int[]
 *   ───────────  ────────────────  ──────────────────  ──────────────
 *   查看队头      dq.front()       peekFirst()         q[head]
 *   查看队尾      dq.back()        peekLast()          q[tail-1]
 *   队头出队      dq.pop_front()   pollFirst()         head++
 *   队尾出队      dq.pop_back()    pollLast()          tail--
 *   队尾入队      dq.push_back(x)  offerLast(x)        q[tail++] = x
 *   判空          dq.empty()       isEmpty()           head == tail
 *   清空          dq.clear()       clear()             head = tail = 0
 *   队列长度      dq.size()        size()              tail - head
 *
 * ==================== 为什么三个都要修 ====================
 *
 *   输入: Scanner(~800ms) → BufferedReader(~100ms)  ≈ 节省 700ms
 *   输出: 循环print(~600ms) → StringBuilder(~10ms)  ≈ 节省 590ms
 *   装箱: Integer(~200ms+GC) → int[](-0ms)          ≈ 节省 200ms
 *
 *   单独修任何一个都可能不够（极限数据时限一般在 1~2s），三个一起修必然 AC。
 *
 * ==================== 另一种只修 I/O 的方案 ====================
 *
 * 如果你坚持用 Java 内置的 Deque：
 *
 * 只需把 Scanner → BufferedReader + StringTokenizer，
 * System.out.print → StringBuilder，保留 ArrayDeque<Integer>。
 *
 * 绝大多数情况下这样就能 AC 了，因为 I/O 是主要瓶颈，装箱是次要的。
 */
