package DFS.luogu_p1644;

import java.util.Scanner;

public class Main {
    static int m,n,a,b,ans;

    // 搜索数组
    static int[] dx,dy;

    static void dfs(int x,int y){
        if(x == n && y == m){
            ans++;
            return;
        }

        for(int i = 0; i < 4;i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 0 || a > n || b > m){
                continue;
            }

            dfs(a,b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //竖直方向
        dx = new int[]{2,1,-1,-2};

        //水平方向
        dy = new int[]{1,2,2,1};

        n = sc.nextInt();
        m = sc.nextInt();


        dfs(0,0);

        System.out.print(ans);
    }
}
