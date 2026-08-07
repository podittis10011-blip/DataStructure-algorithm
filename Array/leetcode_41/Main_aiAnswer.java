package Array.leetcode_41;

import java.util.Scanner;

public class Main_aiAnswer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一步：将所有 <=0 和 >n 的数替换为 n+1（这些数不影响结果）
        // 修复点1 & 2：包含 0 和 n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 第二步：用 Math.abs 取出原始值作为下标，标记对应位置为负
        // 修复点3 & 4：用 -Math.abs() 避免覆盖，用 Math.abs() 避免跳过已标记位置
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        // 第三步：找到第一个未被标记为负的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 修复点5：1~n 全部存在，返回 n+1
        return n + 1;
    }
}
