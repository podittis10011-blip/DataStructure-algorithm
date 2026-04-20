package doublePointer.Leetcode_283;

import java.util.Scanner;

public class Main {
    static int[] nums;
    static int n;

    //两个指针（数组索引）
    //一个从前向后遍历
    //一个从后向前遍历

    //二分查找双指针，left和right

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        n = sc.nextInt();

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        int[] nums = new int[n + 1];

        //开区间
        int left = 0;
        int right = n + 1;
        while(left + 1< right){
            if(nums[left] == 0){
                int a = nums[left];

                //数组统一迁移（包含之前后移的0）
                for

                left ++;
            }
            left++;
            right--;
        }
    }
    
}
