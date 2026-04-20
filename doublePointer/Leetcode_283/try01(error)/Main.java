package doublePointer.Leetcode_283.try01;
import java.util.*;
import java.io.*;


//不能实现相对位置不变的，只能实现一个与初始相对位置“对称”的

//保持非零元素的相对位置



public class Main {
    static final int N =  10010; 
    // static int[] nums;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        int nums[] = new int[n + 1]; 
        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        int l = 1;int r = nums.length - 1;


        while(l + 1 < r){

            //如果末尾位置本来就有0呢？
            if(nums[l] == 0){
                //指针l指向位置之后的所有元素向前移动一位
                for(int i = l;i < r;i++){
                    nums[i] = nums[i + 1];
                }
                // while(nums[r] != 0){

                // }
                // if(nums[r] != 0){
                //     nums[r] = 0;
                // }
                // else{
                //     r --;
                //     nums[r] = 0;
                // }

                l++;
                r--;
            }
            else{
                l++;
            }

        }


        // for(int ans : nums){
        //     System.out.print(ans + " ");
        // }
        for(int i = 1;i <= n;i++){
            System.out.print(nums[i] + " ");
        }
    }    
}
