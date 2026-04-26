package monotonicQueue.luogu_p1886;
import java.util.*;
import java.io.*;

//用队列进行存储
//入队/出队实现窗口滑动的效果

public class Main {
    static int n,k;
    static final int N = 100010;
    static int[] nums = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

    
    }
}
