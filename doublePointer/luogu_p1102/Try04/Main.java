package doublePointer.luogu_p1102.Try04;

import java.util.*;
import java.io.*;

//二分中的最小化查找 + 最大化查找

public class Main {


    static int[] arr;

    static int n,c,ans;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        
        int[] arr = new int[n + 1];

        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextInt();
        }

        //对数组中的元素按照升序进行排序
        Arrays.sort(arr);

        ans = 0;

        for(int k = 1;k <= n;k++){
            int i = k;int j = k;
            //i放在最小化A的位置
            while(i <= n && arr[i] - arr[k] < c){
                i++;
            }
            //j放在最大化A + 1的位置
            while(j <= n && arr[j] - arr[k] <= c){
                j++;
            }
            ans += j - i;
        }

        System.out.print(ans);

    }
}



