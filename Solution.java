// import java.util.*;
// import java.io.*;

import java.util.Scanner;

public class Solution {
    //8.3
    //先给 每个元素平方 + 排序算法
    static int[] array; 
    static int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        array = new int[n + 1];

        for(int i = 1;i <= n;i++){
            array[i] = sc.nextInt();
        }

        //平方部分
        for(int i = 1;i <= n;i++){
            array[i] = array[i] * array[i];
        }

        //排序算法
    }
}


