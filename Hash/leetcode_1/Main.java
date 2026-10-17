package Hash.leetcode_1;

import java.util.Scanner;

public class Main {

    static int n,count,target;
    static int[] nums;
    // static int[][] ans;
    static int[] ans;
    static int[] hash;

    //暴力解：
    // static void twoSum(int[] nums,int target){
    //     int[] a = new int[10010];
    //     int[] b = new int[10010];

    //     int count = 0;

    //     for(int i = 1;i < nums.length;i++){
    //         for(int j = i + 1;j < nums.length;j++){
    //             if(nums[i] + nums[j] == target){
    //                 a[count] = i;
    //                 b[count] = j;
    //                 System.out.println(i + " " +j);
    //                 count ++;
    //             }
    //         }
    //     }

    //     // return a;
    // }
    // static public int[][] twoSum(int[] nums, int target) {
    //     int num = n*(n - 1)/2;
    //     ans = new int[num][2]; 

    //     count = 0;

    //     for(int i = 0;i < nums.length;i++){
    //         for(int j = i + 1;j < nums.length;j++){
    //             if(nums[i] + nums[j] == target){
    //                 ans[count][0] = i;
    //                 ans[count][1] = j;
    //                 count ++;
    //             }
    //         }
    //     }

    //     return ans;
    // }

    //哈希表：
    //数组模拟一张哈希表
    // 利用哈希表的特性：快速查找某一值在哈希表中是否存在
    // target - nums[i]
    static public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            int value = target - nums[i]; 
            // if(hash[target - nums[i]] == 1)
            if(value >= 0&&value < hash.length && hash[value] != 0){
                return new int[]{hash[value] - 1, i};
            }
            hash[nums[i]] = i + 1;
        }

        return new int[]{};
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();

        n = sc.nextInt();
        nums = new int[n]; 

        hash = new int[100000010];

        for(int i = 0; i < n;i++){
            nums[i] = sc.nextInt();

            //nums[i]——value值对应hash表的下表，1——存在该值；0——不存在该值
            // hash[nums[i]] = 1;

            //不能提前录入
            //存储该元素的位置信息，并且位置信息 + 1是为了防止无法区分数组下标默认值为0还是数字存在于下标0处
            // hash[nums[i]] = i + 1;
        }

        ans = twoSum(nums, target);

        // for(int i = 0; i < count;i++){
        //     System.out.print(ans[i][0] + " " + ans[i][1]);
        // }

        for(int x : ans){
            System.out.print(x + " ");
        }
    }

}

