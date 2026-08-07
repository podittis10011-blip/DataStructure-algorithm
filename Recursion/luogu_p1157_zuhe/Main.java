package Recursion.luogu_p1157_zuhe;

import java.util.Scanner;

public class Main {
    static int n,r;

    //用数组存储组合数
    static int[] array;

    public static void dfs(int weizhi,int start){


        if(weizhi + n -start < r){return;}

        // //从第一个位置开始
        // for(int i = weizhi;i <= r;i++){
            //所有位置已经排满，打印输出
        if(weizhi == r + 1){
            for(int i = 1;i <= r;i++){
                System.out.print(array[i]);
                // System.out.printf("%3d",array[i]);
                System.out.print(" ");
            }
            System.out.println();
            // return;
        }
    
            //从第u/start个位置开始枚举
        for(int i = start;i <= n;i++){
            array[weizhi] = i; 
            dfs(weizhi + 1,i + 1);
            // array[weizhi] = 0; 
        }
        }
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();

        array = new int[n + 1];

        dfs(1,1);
    }
}
