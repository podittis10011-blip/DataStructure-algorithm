package BFS.luogu_p1596;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m,ans;
    static char[][] grid;
    static int[] dx,dy;

    public static void bfs(int x,int y){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        grid[x][y] = '.';

        while(!que.isEmpty()){
            int[] t = que.poll();
            for(int i = 0; i < 8; i++){
                int a = t[0] + dx[i], b = t[1] + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= m) continue;
                if(grid[a][b] == '.') continue;
                grid[a][b] = '.';
                que.offer(new int[]{a, b});
            }
        }
    }

    public static int numIslands(char[][] grid) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'W'){
                    ans++;
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[n + 1][m + 1];
        dx = new int[]{-1,-1,-1,0,1,1,1,0};
        dy = new int[]{-1,0,1,1,1,0,-1,-1};

        //初始化地图
        for(int i = 0; i < n;i++){
            String s = sc.next();
            grid[i] = s.toCharArray();
        }

        numIslands(grid);

        System.out.print(ans);
    }    
}
