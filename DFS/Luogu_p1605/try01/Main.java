package DFS.Luogu_p1605.try01;

import java.util.Scanner;

// class Main{
//   static int m,n,t,sx,sy,fx,fy,a,b,ans;
//   static int[][] g;

//   static final int[] dx = {-1,0,1,0};
//   static final int[] dy = {0,1,0,-1};

//   public static void dfs(int x,int y){
//     if(x==fx&&y==fy){ans++;return;}
//     for(int i=0; i<4; i++){
//     int a=x+dx[i], b=y+dy[i];
//     if(a<1||a>n||b<1||b>m){
//       continue;
//     }
//     g[a][b]=1; //锁定现场
//     dfs(a, b);
//     g[a][b]=0; //恢复现场
//   }    
//   } 

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     n = sc.nextInt();
//     m = sc.nextInt();
//     t = sc.nextInt();
//     sx = sc.nextInt();
//     sy = sc.nextInt();
//     fx = sc.nextInt();
//     fy = sc.nextInt();

//     g = new int[n + 1][m + 1];
//     for(int i = 0;i < t;i++){
//       a = sc.nextInt();
//       b = sc.nextInt();
//       g[a][b] = 1;
//     }
//     g[sx][sy] = 1;
//     dfs(sx,sy);
//     System.out.println(ans);


//   }  
// }


import java.util.*;

public class Main {
	
	static int n,m,t;
	
	static int sx,sy,fx,fy;
	static int res;
	
	static int[][] migong;
	
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	//上——>右——>下——>左四个方向进行搜索
	static void dfs(int x,int y) {
		
		//判断是否到达终点
//		if(x == fx&&x == fy) {
		if(x == fx&& y == fy) {
			res++;
			
			//到达终点 ——》 回溯
			return;
		}
		
		for(int i = 0; i < 4;i++) {

			
			
			//四个方向搜索可行路线
//			x += dx[i];
//			y += dx[y];
			int x1 =x + dx[i];
			int y1 =y + dy[i];
			
			//先判断是否越界
//			if(x1 > n||x1 < 1||y1 > n||y1 < 1) {
			if(x1 > n || x1 < 1 || y1 > m || y1 < 1) {
				continue;
			}
			
			//再判断是否遇到障碍物，如果没有判断是否越界直接将x1,y1赋值给数组可能会造成编译错误
			if(migong[x1][y1] == 1) {
				continue;
			}

			
			
			//可行 ——>标记
			migong[x1][y1] = 1;
			//可行 ——> 走
			dfs(x1,y1);
			
			//回溯 ——> 恢复状态
			migong[x1][y1] = 0;
		}
		

			
		//最终一次性打印输出
		
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		
		sx = sc.nextInt();
		sy = sc.nextInt();
		fx = sc.nextInt();
		fy = sc.nextInt();
		
		migong = new int[n + 1][m + 1];
		
		//初始化障碍物坐标
		for(int i =1;i <= t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			migong[x][y] = 1;
		}
		migong [sx][sy] = 1;
		dfs(sx,sy);
		
		System.out.print(res);
	}
}
