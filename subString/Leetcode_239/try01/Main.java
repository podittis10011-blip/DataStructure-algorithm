package subString.Leetcode_239;
import java.util.*;
import java.io.*;


public class Main {

    static final int N = 100010;
    static int[] nums = new int[N];

    static int n,k;
    
    //用数组实现一个单调队列：
    //单调循环队列
    //capacity
    //索引i + 1 % capacity

    static int SearchMax(int[] q){
        int max = -10010;
        //  for(int i = 1;i <= k - 1;i++){
        //      max = Math.max(q[i],max);
        // }
        //比较队列中的元素，从0开始
        for(int i = 0;i < k;i++){
             max = Math.max(q[i],max);
        }
        return max;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i <= n - 1;i++){
            nums[i] = sc.nextInt();
        }

        //用一个数组作为单调队列
        k = sc.nextInt();
        int[] queue = new int[k];

        //初始化单调队列
        int head = 0;int tail = k - 1;
        for(int i = 0;i < k;i++){
            queue[i] = nums[i];
        }
        while(tail < n){
            System.out.println(SearchMax(queue));
            head ++;
            tail ++;
            //窗口后移，queue
            //i肯定要从0~k，
            // 怎样才能让数组中的元素对应的按照0~k的顺序存入该数组中

            int j = head;
            for(int i = 0;i < k;i++){
                //循环处理
            //    queue[i] = nums[head ++];
               //head++，先执行后++
               
                queue[i] = nums[j];
                j++;
            }
            
        }
        
        
    }
}
