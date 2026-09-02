package DFS.luogu_p1596;

import java.util.Scanner;

public class Main {

    static int n,m,ans;
    static char[][] grid;
    static int[] dx,dy;

    public static int numIslands(char[][] grid) {
        for(int i = 0;i < n;i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j] == '1'){
                    ans++;dfs(i,j);
                }
            }
        }

        return ans;
    }

    static void dfs(int x,int y){
        grid[x][y] = '0';
        for(int i = 0; i <8;i++){
            int a = x + dx[i],b = y + dy[i];
            if(a < 0 || a >= n || b < 0 || b >= m){
                continue;
            }
            if(grid[a][b] == '0'){
                continue;
            }
            dfs(a,b);
        }
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

        // for(int i = 0; i < n;i++){
        //     for(int j = 0;j < m;j++){
        //         System.out.print(grid[i][j]);
        //     }
        //     System.out.println();
        // }
        numIslands(grid);

        System.out.print(ans);
    }
}


// import java.util.*;

//连通性问题
//既可以使用DFS解题
//也可以使用BFS解题

//连通性问题

//八个搜索方向
//字符存储
//
//
//public class Main {
//	static final int N = 105;
//	
//	//初始化水塘
////	static char[][] shuitang = new char[N][N];
//	static char[][] shuitang = new char[N][N];
//	static String s;
//	
//	static int n,m;
//	
//	//标记差异
//	
//	//字符类型 
//	
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		m = sc.nextInt();
//		
//		//感觉这道题是不是在初始化水塘时要使用StringBudiler录入？
//		
////		for(int i = 1;i <= n;i++) {
////			for(int j = 1;i <= m;j++) {
////				String s = sc.next();
////				shuitang[i][j] = s.charAt(j - 1);
////			}
////		}
//		
////		for(int i = 1;i <= n;i++) {
////			for(int j = 1;i <= m;j++) {
//////				String s = sc.next();
//////				s.charAt(j - 1);
////				System.out.print(shuitang[i][j]);
////			}
////			System.out.println();
////		}
//		
//		for(int i = 1;i<=n;i++) {
//			s = sc.next();
//			for(int j = 1; j <= m;j++) {
//				shuitang[i][j] = s.charAt(j - 1);
//			}
//		}
//		
////		for(int i = 1;i <= n;i++) {
////			for(int j = 1;j <= m;j++) {
//////				String s = sc.next();
//////				s.charAt(j - 1);
////				System.out.print(shuitang[i][j]);
////			}
////			System.out.println();
////		}
//	}
//}

//package luogu_p1596;
// import java.util.*;

//连通性问题
//既可以使用DFS解题
//也可以使用BFS解题

//连通性问题

//八个搜索方向
//字符存储
//

// public class Main {
// 	static final int N = 105;
	
// 	//初始化水塘
// //	static char[][] shuitang = new char[N][N];
// 	static char[][] tiandi = new char[N][N];
// 	static String s;
	
// 	static int n,m,ans;
	
// 	static int dx[] = {0,1,1,1,0,-1,-1,-1};
// 	static int dy[] = {-1,-1,0,1,1,1,0,-1};
	
// 	//标记差异
	
// 	//字符类型 
	
// 	static void dfs(int x,int y) {
		
// 		//什么情况下扫描完一个水塘？
// 		//
		
// 		//每扫描完一个记得标记
		
// //		if() {
// //			
// //		}
// 		tiandi[x][y] = '.';
// 		for(int i = 0;i < 8;i++) {
// 			//搜索
// 			int a = x + dx[i];
// 			int b = y + dy[i];
						
// 			//判断
// 			//是否越界 是否W
			
// 			//这里有疑问
// 			if(a < 1 || a > n|| b< 1 || b > m) {
// 				continue;
// 			}
// 			if(tiandi[a][b] == '.') {
// 				continue;
// 			}
			
// 			//标记
// //			tiandi[a][b] = '.';
			
// 			//走入
// 			dfs(a,b);
			
// 			//回溯
// //			tiandi[a][b] = 'W';
			
// 		}
		
// 	}
	
// 	public static void main(String args[]) {
// 		Scanner sc = new Scanner(System.in);
// 		n = sc.nextInt();
// 		m = sc.nextInt();
		
// 		//感觉这道题是不是在初始化水塘时要使用StringBudiler录入？

		
// 		for(int i = 1;i<=n;i++) {
// 			s = sc.next();
// 			for(int j = 1; j <= m;j++) {
// 				tiandi[i][j] = s.charAt(j - 1);
// 			}
// 		}
		
// 		for(int i = 1;i <= n;i++) {
// 			for(int j = 1;j <= m;j++) {
// 				if(tiandi[i][j] == 'W') {
// 					ans ++;
// 					dfs(i,j);
					
// 				}
// 			}
// 		}
		
// //		//从左上角开始搜索
// //		tiandi[1][1] = '.';
// //		dfs(1,1);
// 		System.out.print(ans);
// 	}
// }

