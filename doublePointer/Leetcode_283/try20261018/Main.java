package doublePointer.Leetcode_283.try20261018;

import java.util.Scanner;

public class Main {
    
    static int n;
    static int[] nums;

    public static void moveZeroes(int[] nums) {
        
        //定义快慢指针
        int l = 0;

        //如果快指针
        for(int q = 0;q < nums.length;q++){
            if(nums[q] != 0){
                if(l != q){
                    nums[l] = nums[q];
                }
                l++;
            }
        }
        
        for(int i = l;i < nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        for(int i = 0; i < n;i++){
            System.out.print(nums[i] + " ");
        }
    }
}
