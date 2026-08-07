package Hash.Leetcode_349;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] nums;
    static int n,target,low,quick;

    // public static int[] towSum(int nums,int target){}e

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        n = sc.nextInt();

        nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        //快慢指针
        low = 0;
        quick = n - 1;
        while(low < quick){
            if(nums[low] + nums[quick] <= target){
                if(nums[low] + nums[quick] == target){
                    //返回的是排序后的下标
                    System.out.print(low + " " +quick);
                }
                low++;
            }
            if(nums[low] + nums[quick] > target){
                quick--;
            }
        }
    }
}
