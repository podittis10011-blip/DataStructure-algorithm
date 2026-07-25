// import java.util.Scanner;
import java.util.*;
import java.io.*;
public class test {
    static int[] arr;
    static int n,mid;

    // public static BinarySearch(){

    // }
    
    //在可行区域中是最大的
    // public static void binarySearchLeft(int v){
    //     //左右指针都要从边界外开始
    //     int left = 0,right = n + 1;
    //     while(left <= right){
    //         int mid = (left + right) / 2;   
    //         if(mid <= v){
    //             mid = ++left;
    //         }
    //         else{
    //             mid = ++right;
    //         }
    //     }

    // }

    //是否存在

    //最大值：
    public static int binarySearchLeft(int v){
        //左右指针都要从边界外开始
        int left = 0,right = n + 1;
        while(left + 1 < right){
            mid = left + right >> 1;
            //小于等于 ， 等于的时候找到了正确答案返回mid
            if(arr[mid] <= v){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    //最小值
    public static int binarySearchRight(int v){
        int left = 0,right = n + 1;
        while(left + 1 < right){
            mid = left + right >> 1;
            //小于等于 ， 等于的时候找到了正确答案返回mid
            if(arr[mid] >= v){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // int arr[] = new arr[n];
        int value = sc.nextInt();
        arr = new int[n + 1];
        for(int i = 1;i <= n;i++){
            arr[i] = sc.nextInt();
        }

        //从左到右
        //寻找待查找的值中第一个出现的值
        System.out.println(binarySearchLeft(value));
        //寻找待查找的值中最后一个出现的值
        System.out.println(binarySearchRight(value));
    }
}
