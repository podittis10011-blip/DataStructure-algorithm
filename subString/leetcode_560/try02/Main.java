package subString.leetcode_560.try02;

import java.util.*;
import java.io.*;

//这道题如果使用快慢指针
//不像luogu连续数字那道题，数字都是正数、升序且正序

//利用数组中的Arrays.sort()函数重新排序

//尝试一下暴力解法
//分情况讨论：
//无序且正负数都有
//大于小于或等于

//大于，快慢指针前移或者后移并没有任何意义
//都有可能增加或者减少，
//能够确定的是，l++这个序列中包含的元素会减少;r++这个序列中包含的元素会增加;

//看到网上的题解使用前缀和 + 单调队列？

//用前缀和 + 区间和是否可行？
//前缀和能确定这一项比起上一项是增加了还是减少了；
//区间和则能精确的计算满足 ==k的区间个数到底有多少

//一个一维数组记录前缀和的结果
//前缀和每一个下标的前缀和比前面的大——>是正数
//比前面小说明是负数

public class Main {

    static int k,ans;
    static final int N = 20005;
    static int[] nums = new int[N];
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num =sc.nextInt();
        for(int i = 1;i <= num;i++){
            nums[i] = sc.nextInt();
        }
        
        k = sc.nextInt();

        // int sum = 0;
        //从第一个元素开始枚举
        for(int i = 1;i <= num; i++){
            int sum = 0;
            for(int j  = i;j <= num;j++){
                sum += nums[j];
                if(sum == k){
                    ans++;
                    System.out.println(i+ " " + j);
                }
            }
        }
        System.out.println(ans);
    }
}
