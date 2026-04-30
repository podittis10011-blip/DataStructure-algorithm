package subString_huadongchuangkou.luogu_p1638.Try01;
import java.util.*;
import java.io.*;

//逛画展：
//双指针，快慢指针进行维护
//一个数组负责维护当前看的画展包含的画家个数
//  少于总画家数，快指针++
//  多于总画家数，慢指针++
//尽量保证快指针与满指针之间的“滑动窗口”尽量小

//输出第一组满足要求的“组合”

//未满足条件（包含画家个数不完整）
//完整但是不足够小
    //序列中元素个数 == 画家个数（恰好，最佳情况）
    //!=
        //记录最小值序列numsa[i] = x;numsc[x] = i

public class Main {

    static int n,m,nums,x,y;
    static final int N = 1000010;
    static int[] numsa = new int[N];

    //再定义一个变量int nums记录包含画家的个数
    //nums >= m
    //打印输出

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // int[] nums = new int[n + 1];

        //numsb维护的是“窗口”中包含的每一个作家i的画作个数
        int[] numsb = new int[m + 1];

        //不用需要初始化该数组的元素为0，本身就为0；
        // for(int i = 1;i <=m;i++){
        //     numsb[i] = 0;
        // }

        //初始化为0，保证numb中1~m的每一个元素值为1；
        //nums[i] = x;numsb[x] = 1;
        
        //如何对画家数组numsb是否满足条件？


        // 初始化画展
        for(int i = 1;i <= n;i++){
            numsa[i] = sc.nextInt();
        }


        //l和r从哪个位置开始？要不要错位？
        int l = 1;int r = 1;
        numsb[numsa[1]]++;
        nums = 1;

        //循环终止条件太“暴力”了
        while(l <= r){


            // if(nums )

       
            //同一个画家的画作可能多于2
                // 1 2 2 3
                // 2 2 3 1

            //慢指针++的逻辑，慢指针指向的元素在nums[i] > 1;

            //小于等于
            if(nums == m){
                //如果满足条件，判断当前“窗口”序列是否比最小值小
                //直接最小值，break跳出循环语句
                //比原先小
                if((r - l + 1) == m){
                    x = l;y = r;
                    break;
                }
                if(r - l> y - x){
                    x = l;y = r;
                }
            }
            // else{
            //     //当快指针
                
            // }

            //nums < m,r++——>快指针右移——>判断快指针移动后指向的元素如果不包含在序列中——>nums++
            r++;
            if(numsb[numsa[r]] == 0){
                nums ++;
                numsb[numsa[r]]++;
            }

            //numsb[nums[++r]]++;
            if(numsb[numsa[l]] > 1){
                l++;
                numsb[numsa[l]]--;
            }

        }

        //l、r|i、j
        //循环终止条件

        //打印输出条件
        //包含画家数目等于总画家个数

        //最小画家数目

        //只有一个问题：
            //在满足画家总数的前提下，如何保证字串的最小化


        System.out.println(x+ " "+ y);
    }
}
