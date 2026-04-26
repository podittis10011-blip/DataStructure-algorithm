package doublePointer.leetcode_15.try01;
import java.util.*;
import java.io.*;


public class Main {
    static int n;
    final static int N = 3005;
    static int[] nums = new int[N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        //选取一个数组中的一个元素作为基准，L = i + 1
    }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     // n = sc.nextInt();

    //     // for(int i = 1;i <= n;i++){
    //     //     nums[i] = sc.nextInt();
    //     // }

    //     // Arrays.sort(nums);

    //     // int m = sc.nextInt();
    //     // int ans = 0;
    //     // int l = 1;int r = 1;int k = 1;
    //     // while(l <= m >> 1){
    //     //     if(k > m){
    //     //         k -= l;
    //     //         l++;
    //     //     }
    //     //     if(k <= m){
    //     //         if(k == m){
    //     //             // ans++;
    //     //             System.out.println(l + " " + r);
    //     //         }
    //     //         r++;
    //     //         k += r;
    //     //     }
    //     // }
    // }
}
