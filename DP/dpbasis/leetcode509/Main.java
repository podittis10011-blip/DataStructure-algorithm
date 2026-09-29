import java.util.Scanner;

//这道题的实现方式感觉和前缀和的内容也很像

class Main {
    static int n;
    static int[] dp;

    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        for(int i = 2;i <= n;i++){
            // dp[i] = dp[i - 1] + dp[i - 2];
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
    
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int ans = fib(n);

        System.out.println(ans);


    }
}

// class Solution {

//  static int[] dp = new int[2];
//  public static int fib(int n){
//         dp[0] = 0;
//         dp[1] = 1;
//         if(n <= 1){
//             return n;
//         }
//         for(int i = 2;i <= n;i++){
//             // dp[i] = dp[i - 1] + dp[i - 2];
//             int sum = dp[0] + dp[1];
//             dp[0] = dp[1];
//             dp[1] = sum;
//         }

//         return dp[1];
//     }
// }