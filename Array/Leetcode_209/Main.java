package Array.Leetcode_209;

import java.util.Scanner;

public class Main {
    static int n,target;
    static int[] nums;

    static public int minSubArrayLen(int target, int[] nums) {
        
        //定义快慢指针，快指针右移增，慢指针右移减
        // int l = 0,q = 0,sum = 0,length = 10010;
        int l = 0,q = 0,sum = 0,length = nums.length + 1;

        sum += nums[0];
        // while(l <= q && l <= n - 1 && q <= n - 1){
        while(q < nums.length){
            if(sum >= target){
                length = Math.min(length,q - l + 1);
                sum -= nums[l];
                l++;
            }else{
                q++;
                if(q < nums.length){
                    sum += nums[q];
                }
            }
        }

        // if(length == 10010){
        //     length = 0;
        // }

        // return length;
        return length == nums.length + 1 ? 0 : length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        target = sc.nextInt();
        n = sc.nextInt();

        // nums = new int[n + 1];
        nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(minSubArrayLen(target, nums));

    }
}

