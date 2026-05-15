package Array.leetcode_189.jiefa01;
import java.util.*;
import java.io.*;


//感觉这道题似乎可以使用循环队列进行实现？
//底层基于数组实现
//capacity

//借助一个“原始数组”，存储数组轮转前的初始状态
//再借助一个“轮转（后的）数组”存储数组轮转后的状态
//(索引位置 + k) % capacity

public class Main {

    static int[] nums;
    static int[] ansArray;

    //n:要被轮转的原始数组有效元素大小及容量大小
    static int n,k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        nums = new int[n];
        ansArray = new int[n];

        //数组初始化操作
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        //轮转操作
        //在“原始数组”经过轮转操作后，应放在最终位置处的元素放入“轮转数组”
        int cap = n;
        for(int i = 0;i < n;i++){
            int fnl = (i + k) % cap;
            ansArray[fnl] = nums[i]; 
        }


        for(int i = 0;i < n;i++){
            System.out.print(ansArray[i] + " ");
        }
    }
    
}

// test01:
// 7 3
// 1 2 3 4 5 6 7