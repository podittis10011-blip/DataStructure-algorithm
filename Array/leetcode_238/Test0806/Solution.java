package Array.leetcode_238.Test0806;

import java.util.Scanner;

//还是使用前缀和的思想，但是这次是正序 + 倒叙并行
public class Solution {
    static int[] nums,answer,qianzhui,houzhui;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        qianzhui = new int[n];
        houzhui = new int[n];
        answer = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }


        //从左到右的计算前缀和
        qianzhui[0] = nums[0];
        for(int i = 1;i < n;i++){
            qianzhui[i] = qianzhui[i - 1] * nums[i];
            // System.out.println(qianzhui[i]);
        }
        
        // for

        //从右向左的计算后缀和
        houzhui[n - 1] = nums[n - 1];
        for(int i = n - 2;i >= 0;i--){
            houzhui[i] = houzhui[i + 1] * nums[i];
            // System.out.println(houzhui[i]);
        }
        answer[0] = houzhui[1];
        answer[n - 1] = qianzhui[n - 2];
        for(int i = 1;i < n - 1;i++){
            answer[i]= qianzhui[i - 1] * houzhui[i + 1];
        }

        for(int i = 0;i < n;i++){
            System.out.println(answer[i]);
        }
    }
}
