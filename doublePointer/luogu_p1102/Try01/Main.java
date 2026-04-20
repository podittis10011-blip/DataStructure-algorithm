package doublePointer.luogu_p1102.Try01;

import java.util.*;
import java.io.*;



public class Main {
    //使用数组对“该串数”进行存储
    static final int N = 2005;
    static int[] nums = new int[N];

    static int n,c;
    static int ans = 0; 


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        // int nums[] = new int[n + 1];

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }
        
        //先要对该数对进行排序,保证右指针的数值要大于左指针的数值
        Arrays.sort(nums);

        // for(int a : nums){
        //     System.out.println(a);
        // }

        int l = 1,r = 1;


        //什么时候需要终止该循环？
        // while(l <= r){
        //     if(nums[r] - nums[l] == c){
        //         ans ++;
        //     }
        //     if(nums[r] - nums[l] < c){
        //         r++;
        //     }
        //     if(nums[r] - nums[l] > c){
        //         l++;
        //     }
        // }

        // for(int k = )

        System.out.print(ans);


    }


    
}
