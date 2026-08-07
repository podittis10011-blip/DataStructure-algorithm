package Recursion.luogu_1706_pailie;

import java.util.Scanner;
public class Main {

    final static int N = 10;
    static int n;
    static int[] state;
    static boolean[] used;

    public static void dfs(int weizhi){
        if(weizhi > n){
            for(int i = 1; i <= n;i++){
                System.out.print(state[i]);
                System.out.print(" ");
            }
            System.out.println();
            // return;
        }

        for(int i = 1;i <= n;i++){
            //如果当前排列中不存在这个数
            if(!used[i]){
                state[weizhi] = i;
                used[i] = true;
                dfs(weizhi + 1);

                //恢复现场
                state[weizhi] = 0;
                used[i] = false;
            }
        }
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        state = new int[N];
        used = new boolean[N];

        dfs(1);
    }
}
