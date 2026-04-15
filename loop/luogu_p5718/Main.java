package loop.luogu_p5718;

import java.util.*;
import java.io.*;

public class Main {


    final static int N = 105;

    static int n;
    
    static int[] arr = new int[N];

    static int minValue = 1005;
    
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();


        //比较n个数，初始化
        for(int i = 1;i <= n; i++){
            arr[i] = sc.nextInt();
            minValue = Math.min(minValue, arr[i]);
        }
        
        System.out.print(minValue);
    }
}
