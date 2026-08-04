import java.util.Scanner;

// 8.3：
// 一维前缀和计算公式：
// 
public class qujianhe {
   

    static int[] array;
    static int n,a,b;

    //前缀和数组：
    static int[] qianzhuihe;
    static int[] qujianhe;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        array = new int[n + 1];
        qianzhuihe = new int[n + 1];

        for(int i = 1;i <= n;i++){
            array[i] = sc.nextInt();
        }

        qianzhuihe[1] = array[1];
        //计算前缀和：
        for(int i = 1; i < n;i++){
            qianzhuihe[i + 1] = qianzhuihe[i] + array[i + 1];
        }

        for(int i = 1; i<= n;i++){
            System.out.println(qianzhuihe[i]);
        }

        //计算区间和
        // for(int i = 1; i<= n;i++){
        // }

        //一维区间和
        ans = qianzhuihe[b] - qianzhuihe[a];
        System.out.println(ans);

        // 二维前缀和
        // 
        }
}
