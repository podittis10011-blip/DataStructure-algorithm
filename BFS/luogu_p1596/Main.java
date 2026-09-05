package BFS.luogu_p1596;

import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m,ans;
    static char[][] grid;
    static int[] dx,dy;
    static Queue<> que;

    public static int numIslands(char[][] grid) {
        
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
