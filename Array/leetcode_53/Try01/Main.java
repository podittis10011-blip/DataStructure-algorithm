package Array.leetcode_53.Try01;
import java.util.*;
import java.io.*;

//基于一维前缀和、一维区间和进行计算
//只要是正数，加起来一定比不加大

//从第一项枚举到第n项，1~n，先算前缀和后算区间和

//一维前缀和：s[i] = s[i - 1] + a[i];
//一维区间和(包含i)：r[j~i] = s[j] - s[i] + a[i];

//二维前缀和：s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
//二维区间和：s[i2~i1][j2~j1] =s[i1][j1] - s[i1][j2 - 1] - s[i2 - 1][j1] + s[i2][j2];

//先计算前缀和，将数组的前n项的前缀和存入一个数组，
//然后以每个i为基准计算每个i到j的区间和
//每次更新连续数组的最大值


public class Main {

    static final int N = 10000010;
    static int n,ans;
    static int[] nums = new int[N];
    
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        ans = -100000010;

        for(int i = 1;i <= n;i++){
            nums[i] = sc.nextInt();
        }

        int[] sum = new int[n + 1];

        sum[1] = nums[1];
        //计算前n项的前缀和
        for(int i = 2;i <=n;i++){
            sum[i] = sum[i - 1] + nums[i];
        }

        for(int i = 1;i <= n;i++){
            for(int j = i;j <= n;j++){
                ans = Math.max(sum[j] - sum[i] + nums[i], ans);
            }
        }

        System.out.println(ans);
    }
    
}
//wrongError_test01:
// 5
// -1 -2 -3 -4 -5
//wrong_ans:-3

//wrongError_test02:

//wrongError_test03:
// 3
// -5 -2 -3

//wrong_ans:-5