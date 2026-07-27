import java.util.*;
import java.io.*;

// ACM:
public class removeElement {
    static int[] arr;
    static int k = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int val = sc.nextInt();
        int n = sc.nextInt();

        arr = new int[n + 1];

        for(int i = 1; i <= n;i++){
            arr[i] = sc.nextInt();
        }

        //进行匹配
        for(int i = 1; i <= n;i++){
            if(arr[i] == val){
                arr[i] = -1;
                k++;
            }
        }

        System.out.println(k);

        for(int i = 1; i <= n;i++){
            if(arr[i] != -1){
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
    }
}

//leetcode：
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int n = nums.length;

//         // 标记
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == val) {
//                 nums[i] = -1;
//             }
//         }

//         // 将不等于 -1 的元素前移
//         int k = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] != -1) {
//                 nums[k] = nums[i];
//                 k++;
//             }
//         }

//         return k;
//     }
// }

//双指针写法：