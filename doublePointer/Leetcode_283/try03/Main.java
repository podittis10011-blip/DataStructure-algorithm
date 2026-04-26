package doublePointer.Leetcode_283.try03;
import java.util.*;
import java.io.*;

public class Main {

    static int n;
    // static int

    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();

        int nums[] = new int[n + 1];

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        int l = 1;
        for(int r = 1;r <= n;r++){
            if(nums[r] != 0){
                nums[l] = nums[r];
                l++;
            }
        }
        //末端补0——>末端指的是——>l所在位置及以后的所有元素
        for(int i = l;i <= n;i++){
            nums[i] = 0;
        }

        for(int i = 1;i <= n;i++){
            System.out.print(nums[i] + " ");
        }

    }
    
}
