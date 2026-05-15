package Array.luogu_p1496.Try01.Try02;

import java.util.*;
import java.io.*;


//两个数组对区间情况进行存储
//区间起点、区间终点
//区间长度

//三种区间情况

//两两进行比较：
    //超过两个以上的区间具备重叠关系

//重叠
    //部分重叠
    //完全重叠

//相离

//要根据区间起点对区间进行排序


public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] intervals = new int [n][2];
        for(int i = 0;i < n;i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }


        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

        long totalLen = 0;

        int curStart = intervals[0][0];

        // int curStart = intervals[0][0];

        int curEnd = intervals[0][1];

        for(int i = 1;i < n;i++){
            int nextStart = intervals[0][0];
            int nextEnd = intervals[0][1];

            if(nextStart < curEnd){
                curEnd = Math.max(curEnd, nextEnd);
            }
            else{
                totalLen += (curEnd - curStart);
                curStart = nextStart;
                curEnd = nextEnd;
            }

            totalLen += (curEnd - curStart);

            System.out.println(totalLen);
        }


    }
}
