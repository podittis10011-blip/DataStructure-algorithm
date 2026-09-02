package DFS.Luogu_p1605.try02;

import java.util.Scanner;

public class Main {
    static int m,n,t,sx,sy,fx,fy,a,b,ans;

    // 迷宫数组
    static int[][] g;

    // 搜索数组
    static int[] dx,dy;

    static void dfs(int x,int y){
        if(x == fx && y == fy){
            ans++;
            return;
        }

        for(int i = 0; i < 4;i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 1 || a > n|| b < 1 || b > m || g[a][b] == 1){
                continue;
            }

            g[a][b] = 1;
            dfs(a,b);
            g[a][b] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        g = new int[6][6];
        dx = new int[]{-1,0,1,0};
        dy = new int[]{0,1,0,-1};

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        sx = sc.nextInt();
        sy = sc.nextInt();
        fx = sc.nextInt();
        fy = sc.nextInt();

        // 初始化障碍物坐标
        for(int i = 0;i < t;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            g[a][b] = 1;
        }

        //走过的位置统一赋值为1——“不可再走”
        g[sx][sy] = 1;

        dfs(sx,sy);

        System.out.print(ans);
    }
}
