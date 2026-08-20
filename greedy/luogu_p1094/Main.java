package greedy.luogu_p1094;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int targetValue,n,ans,left,right;
    static int nums[];

    public static void main(String[] args) {
        //输入初始化
        Scanner sc = new Scanner(System.in);
        targetValue = sc.nextInt();
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        //创建并初始化左右指针
        left = 0;right = nums.length - 1;

        ans = 0;
        
        // if(nums[left] > targetValue){
        //     System.out.println(ans);
        //     return;
        // }

        //左指针位置保持不动，右指针寻找合适初始位置
        while(nums[left] + nums[right] > targetValue){
            ans++;
            right--;
        }

        while(left <= right){
            // ans += (right - left + 1)/2 + (right - left + 1)%2;
            // System.out.println(ans);
            if(nums[left] + nums[right] <= targetValue){
                ans++;
                left++;right--;
                continue;
            }
            else{
                ans++;
                right--;
            }
        }

        System.out.println(ans);
    }
}
