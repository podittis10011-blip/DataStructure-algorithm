package Array.leetcode_189.solution2.Try20261024;

import java.util.Scanner;

public class Main {
    static int[] nums;
    static int n,k;

    static public void rotate(int[] nums, int k) {
        
        k %= nums.length;

        //三次反转
        //第一次：整个数组反转
        reverse(nums, 0, nums.length - 1);
        
        //第二次：前k个元素进行反转
        reverse(nums,0,k - 1);

        //第三次：剩余元素进行反转
        reverse(nums,k,nums.length - 1);
    }

    //实现对一个数组中制定元素的反转功能；
    //基于双指针进行实现
    static void reverse(int[] nums,int l,int r){
        // int l = start;int r = end;

        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        nums = new int[n];

        k = sc.nextInt();

        for(int i = 0;i < nums.length;i++){
            nums[i] = sc.nextInt();
        }

        rotate(nums,k);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
