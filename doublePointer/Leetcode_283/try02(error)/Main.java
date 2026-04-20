package doublePointer.Leetcode_283.try02;
import java.util.*;
import java.io.*;

//使用快慢指针
//快指针在前方检索是否存在零值元素

//快指针指向零值元素的后一个元素整体前移
//num计数加加

//最后末位补零

//非零元素

//存在零值元素
//

//输入、输出问题
// -----------------------------------------------------
//快指针遍历非零元素

public class Main {
    static final int N = 10010;
    static int n,num;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] nums = new int[n + 1];

        //初始化0的个数
        num = 0;

        //
        for(int i = 1; i <= n;i++){
            nums[i] = sc.nextInt();
        }

        int l = 1;int r = 1;
        //r索引指向零值元素，将指向零值元素的所有元素前移一位，覆盖0值元素
        for(int i = 1;i <= n;i++){
            if(nums[r] == 0){
                for(int j = r;j <= n - r;j++){
                    nums[j] = nums[j + 1];
                }
                num++;
                continue;
                //如果注释掉，continue,如果下一位是一个非0数值，会多一次for循环
                //会导致r索引数组越界
            }
            if(nums[r] != 0){
                r++;
            }
        }
        for(int i = n - num + 1;i <= n;i++){
            nums[i] = 0;
        }

        for(int i = 1;i <= n;i++){
            System.out.print(nums[i] + " ");
        }
    }
}

//指针错乱
//每次移位操作
//原来指向的索引r都会

//如果遇到两个相邻的0元素，就会造成