package doublePointer.Leetcode_11;

import java.util.*;
import java.io.*;

//双指针枚举
//变量width记录宽度(两指针间的间隔)
//变量higth记录最低高度（两指针边界......）
//记录最大容积（一旦有更大的出现，直接进行更换）

//枚举方法
//i = 1,j = 1;
//rongji = 0;
//minHigh
//width

//参考案例：
//找出最大区间和

//数组存储

public class Main{
    static int n;
    static int  minHigth = 10010;
    static int maxmum = 0;
    static final int N = 100010;
    static int[] rongqi= new int [N];

    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //初始化容器
        for(int i = 1;i <= n;i++){
            rongqi[i] = sc.nextInt();
        }

        int i = 1,j = 1;
        while(i <= n >> 1){;
            minHigth = Math.min(i,j);
            maxmum =Math.max(maxmum,minHigth * (j - i)) ;


            //分为比原先大/比原先小两种情况
            //跟原先一样？？

            //比原来大
            if(minHigth * (j - i) > maxmum){
                j ++;
            }
            
            // //等于这种情况该怎么办？

            // if(minHigth * (j - i) < maxmum){
            //     j ++;
            // }


        }
    }

}