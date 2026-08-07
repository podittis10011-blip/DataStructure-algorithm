package Array.leetcode_238.Test0806;

import java.util.Scanner;
//

public class Main {
    static int n;
    static int[] nums,qianzhui,qujian,answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n + 1];
        qianzhui = new int[n + 1];
        qujian = new int[n + 1];

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        qianzhui[1] = nums[1];
        //计算前缀积
        for(int i = 2;i <= n;i++){
            qianzhui[i] =qianzhui[i - 1] * nums[i]; 
        }

        // for(int i = 1;i <= n;i++){
        //     System.out.println(qianzhui[i]);
        // }

        // nums[0] = qianzhui[0] = 0;
        // for(int i = 1;i <= n;i++){
        //     System.out.println(answer[i] = qianzhui[i - 1] * qianzhui[n] / qianzhui[i + 1]);
        // }
        for(int i = 1;i <= n;i++){
            System.out.println(qianzhui[n] / nums[i]);
        }
    }
}

/*
 * ============================================================
 * 正确解法：左右前缀积 两次遍历（O(n) 时间，O(1) 额外空间）
 * 题目要求不允许使用除法，上述解法使用了除法，不符合要求。
 * ============================================================
 *
 * 思路：
 *   第一遍（左 → 右）：answer[i] 存储 nums[i] 左侧所有元素的乘积
 *   第二遍（右 → 左）：用一个变量 right 记录右侧乘积，乘回 answer[i]
 *
 *   answer[i] = (nums[0] * ... * nums[i-1]) * (nums[i+1] * ... * nums[n-1])
 *             = 左侧前缀积          *  右侧后缀积
 *
 * 正确实现代码：
 *
 *   class Solution {
 *       public int[] productExceptSelf(int[] nums) {
 *           int n = nums.length;
 *           int[] answer = new int[n];
 *
 *           // 第一遍：左 → 右，answer[i] = nums[0] * ... * nums[i-1]
 *           answer[0] = 1;
 *           for (int i = 1; i < n; i++) {
 *               answer[i] = answer[i - 1] * nums[i - 1];
 *           }
 *
 *           // 第二遍：右 → 左，乘上右侧后缀积
 *           int right = 1;  // 右侧乘积，初始为 1（最右侧没有元素）
 *           for (int i = n - 1; i >= 0; i--) {
 *               answer[i] *= right;   // 左侧积 * 右侧积
 *               right *= nums[i];     // 更新右侧积
 *           }
 *
 *           return answer;
 *       }
 *   }
 *
 * 示例演示（nums = [1,2,3,4]）：
 *   第一遍后 answer = [1, 1, 2, 6]  （分别是各位置左侧元素乘积）
 *   第二遍：
 *     i=3: answer[3] = 6*1=6,   right = 1*4=4
 *     i=2: answer[2] = 2*4=8,   right = 4*3=12
 *     i=1: answer[1] = 1*12=12, right = 12*2=24
 *     i=0: answer[0] = 1*24=24, right = 24*1=24
 *   结果：[24, 12, 8, 6] ✓
 */
