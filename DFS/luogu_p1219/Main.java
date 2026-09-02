package DFS.luogu_p1219;

import java.util.Scanner;

//这道题本质上也是回溯算法的一种类型，使用回溯算法的板子也能解

public class Main {
    static int n,ans;

    //pos记录棋盘上棋子放的位置
    //标记占据位置的数组：c标记行和列 p标记撇对角线 q标记捺对角线
    static int[] pos,c,p,q;

    static void print(){
        if(ans <= 3){
            for(int i = 1;i <= n;i++){
                System.out.print(pos[i] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int i){
        if(i > n){
            ans++;print();return;
        }
        for(int j = 1;j <= n;j++){
            if(c[j] == 1 || p[i + j] == 1|| q[i - j + n] == 1){
                continue;
            }
            pos[i] = j;
            c[j] = p[i + j] = q[i - j + n] = 1;
            dfs(i + 1);
            c[j] = p[i + j] = q[i - j + n] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        pos = new int[n + 1];
        c = new int[n + 1];

        //p和q数组应该开大一些，考虑到p[i + j]及q[i - j + n] i + j范围：2n i - j + 1范围：2n - 1 
        // p = new int[30];
        p = new int[2 * n + 1];
        // q = new int[30];
        q = new int[2 * n + 1];

        dfs(1);

        System.out.println(ans);
        
    }
}
