package doublePointer.luogu_p1102.Try02;

import java.util.*;
import java.io.*;

// 先对元素进行一轮排序，排序之后才能使用二分
// 再依次以每个元素为基准进行枚举
// arr[i] + C = A?
// 再arr[i] ~ arr[n]的区间内对A进行查找,A肯定在arr[i](B)的右侧
// 无
// 有（1个/多个）
// 符合要求的元素经过排序之后可能不止一个，按照我的思路，一次二分只能找到一个

public class Main {
    
    static final int N = 2005;
    static int[] arr = new int[N];

    static int n,ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextInt();
        }
    }
}
