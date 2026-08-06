package Array.leetcode_41;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int[] nums;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0;i <= n - 1;i++){
            nums[i] = sc.nextInt();
        }

    // n = nums.length;
        for(int i = 0;i <= n-1;i++){
            //等于0怎么办？
            if(nums[i] < 0){
                //将所有负数赋值为n + 1
                nums[i] = n + 1;
            }
        }

        //将所有 < n的数对应的位置标记为负，已经为负的不用再标记
        for(int i = 0;i <= n-1;i++){
            //不包含n - 1;
            if(nums[i] < n && nums[i] > 0){
                nums[nums[i] - 1] = -nums[i];
            }
        }

        //返回第一个未被标记为负的正整数
        for(int i = 0;i <= n-1;i++){
            if(nums[i] >= 0){
                System.out.print(i + 1);
                break;
            }
        }
    }
}
