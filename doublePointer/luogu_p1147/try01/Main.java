package doublePointer.luogu_p1147.try01;

import java.util.*;
import java.io.*;


public class Main {
    static int m;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();

        
        
        //临时变量k存储窗口区间之和
        int i = 1,j = 1,k = 1;
        //j在i右端
        //伸缩窗口
        
        //始终不明白为什么改循环语句限制条件为 i <= m >> 1;
        while(i <= m >> 1){
            //窗口区间内的数小于m
            if(k < m){
                j++;
                k += j;
            }
            
            //窗口区间内的数大于m
            if(k >= m){
                if(k == m){
                    System.out.println(i + " " + j);
                }
                k -= i;
                i++;

            }



            
            //i右移 ——> 区间之和减小
            //j右移 ——> 区间之和增大
        }
        
    }
}
