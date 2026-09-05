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

// import java.util.*;

// //DFS习题
// //搜索方式 — 向四周打“探照灯”

// //递归和回溯的过程
// //如果满足条件 ——> 递归  ——> 标记
// //不满足条件 ——> 直接跳过 ——> 回溯 ——>恢复状态
// //

// public class Main {
// 	static int n,m,total;
// 	static final int N = 20;
// 	static int[][] qipan = new int[N][N];
	
// 	//搜索方向：
// 	static int[] dx = {-2,-1,1,2};
// 	static int[] dy = {1,2,2,1};
	
// 	static void dfs(int x1,int x2) {
		
		
// 		//判断条件
// 		if(x1 == n&&x2 == m) {
// 			total ++;
// 			return;
// 		}
		
// 		//1.容易把搜索的初始位置写为1，导致其中有一个数目不全
// 		for(int i = 0; i < 4;i++) {
// 			int a = x1 + dx[i];
// 			int b = x2 + dy[i];
			
// 			//2.判断是否越界
			
// 			//判断越界条件时，最容易错的地方是m默认写成n
// //			if(a < 1||a >n||b < 1||b > m) {
// 			if(a < 0||a > n|| b < 0|| b >m) {
// 				continue;
// 			}
			
// 			//不用回溯，无需标记
// 			dfs(a,b);
// 		}
		
// 	}

// 	public static void main(String args[]) {
// 		Scanner sc = new Scanner(System.in);
// 		n = sc.nextInt();
// 		m = sc.nextInt();
		
		
		
// 		dfs(0,0);
		
// 		System.out.print(total);
		
// 	}
// }
