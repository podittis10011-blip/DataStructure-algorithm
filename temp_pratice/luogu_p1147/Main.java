package temp_pratice.luogu_p1147;

import java.util.Scanner;

public class Main {
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();

        int low = 1,fast = 1,sum = 1;

        //计算连续相加的正整数的数学计算公式：
        //(low + fast)(fast - low + 1)/2
        // while(low <= M/2){
        //     //小于M
        //     if((low + fast) * (fast - low + 1)/2 < M){
        //         fast++;
        //     //大于M
        //     }else if((low + fast) * (fast - low + 1)/2 > M){
        //         low++;
        //     }
        //     //等于M
        //     else{
        //         System.out.print(low +" "+ fast);    
        //     }
        // }
        // while(low <= M/2){
        //     //小于M
        //     if(sum < M){
        //         sum += fast;
        //         fast++;
        //     //大于M
        //     }else if(sum > M){
        //         sum -= low;
        //         low++;
        //     }
        //     //等于M
        //     else{
        //         System.out.print(low +" "+ fast);    
        //     }
        // }
            while(low <= M/2){
            //小于M
            if(sum < M){
                sum += fast;
                fast++;
            //大于M
            }if(sum > M){
                //等于M
                if(sum == M){
                    System.out.print(low +" "+ fast);       
                }
                sum -= low;
                low++;
            }
        }
    }
}


// import java.util.*;
// import java.io.*;


// /*
//     这道题与之前在洛谷做过的一道双指针的题十分类似，
//     不同之处是这道题中的数组元素似乎不是有序的
//     打算将其进行升序排列——>好像不大行

//     包含负数、且无序


//     双指针？

//     小于
//     判断左指针（是否是负数——>是——>i++）
//     判断右指针 + 1（是否是正数——>是——>j++）
//     左指针
//     右指针
// */

// public class Main {
//     static int m,ans;

//     //输入一个数字m和一个数字t，输出该1~m中相加起来等于t的串的个数

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
        
//         m = sc.nextInt();
//         // t = sc.nextInt();

//         int l = 1;int r = 1;int k = 1; 
//         ans = 0;
//         //始终没有搞明白为什么l <= m >> 1时作为循环执行条件
//         while(l <= m >> 1){
//             if(k < m){
//                 r++;
//                 k += r;
//             }
//             if(k >= m){
//                 if(k == m){
//                     ans++;
//                     System.out.println(l + " " + r);
//                 }
//                 k -= l;
//                 l++;
//             }

//             // else{
//                 // if(k == m){
//                 //     ans++;
//                 //     System.out.println(l + " " + r);
//                 // }
//                 // else{
//                     // k -= l;
//                     //  l++;
//                 // }

//                 //无论是否等于,l都要前移，不然会陷入死循环，也能看出为什么设置l的判断条件的原因
//                 // k -= l;
//                 // l++;
//             // }
//         }

//         // System.out.println(ans);
//     }
    
// }

//ans1:
// import java.util.Scanner;

// public class Main {
//     static int M;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         M = sc.nextInt();

//         int low = 1,fast = 1,sum = 1;
//         while(low <= M/2){
//             //小于M
//             if(sum < M){
//                 fast++;
//                 sum += fast;
//             //大于M
//             }if(sum >= M){
//                 //等于M
//                 if(sum == M){
//                     System.out.println(low +" "+ fast);       
//                 }
//                 sum -= low;
//                 low++;
//             }
//         }
//     }
// }

//ans2:
// import java.util.Scanner;

// public class Main {
//     static int M;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         M = sc.nextInt();

//         int low = 1,fast = 1;
//         while(low <= M/2){
//             //小于M
//             if((low + fast) * (fast - low + 1)/2 < M){
//                 fast++;
//                 // sum += fast;
//             //大于M
//             }if((low + fast) * (fast - low + 1)/2 >= M){
//                 //等于M
//                 if((low + fast) * (fast - low + 1)/2 == M){
//                     System.out.println(low +" "+ fast);       
//                 }
//                 // sum -= low;
//                 low++;
//             }
//         }
//     }
// }

//question:
//为什么while循环终止条件要设置为：
//当左端点超过 M/2 时，以它为起点的任何连续段之和必然大于 M，不可能再凑出等于 M 的解，所以循环可以终止。
//low + (low + 1) ≤ M  ⇒  low ≤ (M − 1) / 2