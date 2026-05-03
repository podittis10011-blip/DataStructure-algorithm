package doublePointer.luogu_p1102.Try03;

import java.util.*;
import java.io.*;

//二分中的最小化查找 + 最大化查找

public class Main {

    // static final int N = 200010;
    // static int[] arr = new int[N];
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


        //快慢双指针
        //i + 1
        //arr[i] - arr[k] = C
        //i - k 的值等于

        ans = 0;

        // 现在查找以k值为基准，并且满足条件的A的个数()
        //快、慢指针之间的区间即为该基准元素的解
        for(int k = 1;k <= n;k++){
            int t = k + c;
            //左右指针
            //最小化查找
            int l = k - 1;int r = n + 1; 
            while(l + 1 < r){
                int mid = (l + r) >> 1;
                if(arr[mid] >= t){
                    r = mid;
                }
                else{
                    l = mid;
                }
            }
            // if(arr[r] == t){
            //     int i = r;
            //     while(arr[i++] == t){
            //         ans += 1;
            //     }
            // }
            //最大化查找
            int i = r;
            l = k - 1;r = n + 1;
            while(l + 1 < r){
                int mid = (l + r) >> 1;
                if(arr[mid] <= t){
                    l = mid;
                }
                else{
                    r = mid;
                }
            }
            int j = l + 1;
            ans += j - i; 
        }

        // 二分查最小
        System.out.println(ans);
    }
}


//最小化二分：
//开区间
    //l指针从0开始,r指针从n + 1开始
//可行区域
    // 最小化二分，l
    //while(l + 1 < r)
    //int mid =  l + r >> 1  
    // if(arr[mid] >= t){
    //r = mid;  
    //}
    // else{
    //l = mid;
    //}
    //return r
//不可行区域
//指针


//最大化可行域 + 最小化可行域 ——> 区间得出最终结果

//ERROR:
// Test03:
// 5 0
// 2 2 2 2 2
// ans:4

//Test04:
// 6 2
// 1 3 3 5 5 7
// ans:5

//Test05:
// 5 1073741823
// 0 1073741823 2147483646 1 2
// ans:1