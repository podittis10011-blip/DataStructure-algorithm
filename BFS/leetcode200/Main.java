package BFS.leetcode200;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// public class Main {
//     static int n,m;
//     static char[][] grid;

//     public static int numIslands(char[][] grid) {


        
//         return 0;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         n = sc.nextInt();m = sc.nextInt();

//         //创建并初始化地图
//         grid = new char[n + 1][m + 1];
//         for(int i = 0; i < n;i++){
//             String s = sc.next();
//             grid[i] = s.toCharArray();
//             // toCharArray()方法解析:
//             // String.toCharArray() 把当前字符串转成 char[]，每个字符占一个下标。
//             // 例如: "110" -> {'1','1','0'}，长度等于字符串长度。
//             // 这里用它把一行输入直接赋给 grid[i]，方便按格子访问地图。
//             // 注意: 返回的是新数组，修改它不会改原字符串；空串则得到长度为 0 的数组。
//         }
        
//     }
// }

//luogu:
class Main{

    static int n,m;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] grid;

    // 错误写法：static Queue<char[][]> que;
    // Java: 用 int[2] 表示一对坐标，Queue + LinkedList 实现
    // C++: queue<pair<int,int>> q;


    static int numIslands(char[][] grid){
        int a = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1'){
                    a++;
                    bfs(i,j);
                }
            }
        }
        return a;
    }

    static void bfs(int x,int y){
        Queue<int[]> que = new LinkedList<>();

        //记下坐标
        que.offer(new int[]{x,y});

        //入队后标记为'0',表示已经遍历过该'陆地'
        grid[x][y] = '0';

        while(!que.isEmpty()){
            //取出队首元素
            int[] t = que.poll();

            //广搜的过程
            for(int i = 0;i < 4;i++){
                //横坐标
                int a = t[0] + dx[i];
                //纵坐标
                int b = t[1] + dy[i];
                //越界
                if(a < 0||a >= n||b < 0||b >= m){
                    continue;
                }
                //是“海洋”/已经标记过了
                if(grid[a][b] == '0'){
                    continue;
                }

                //将遍历到的元素加入到队列中
                grid[a][b] = '0';
                que.offer(new int[]{a,b});
            }
        }
    }

    public static void main(String[] args) {
        // ArrayList<ArrayList<Character>> arr= new ArrayList<ArrayList<Character>>(); 
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[n + 1][m + 1];

        for(int i = 0; i < n;i++){
            String str = sc.next();
            // toCharArray()方法解析:
            // String.toCharArray() 把当前字符串转成 char[]，每个字符占一个下标。
            // 例如: "110" -> {'1','1','0'}，长度等于字符串长度。
            // 把一行输入直接赋给 g[i]，方便按格子访问地图。。

            //g[i]：第 i 行的引用，类型是 char[]（一维字符数组）
            grid[i] = str.toCharArray();
        }
        int ans = numIslands(grid);
        System.out.println(ans);

        // for(int i = 0;i < n;i++){
        //     for(int j = 0;j < m;j++){
        //         if(g[i][j] == '1'){
        //             ans++;
        //             bfs(i,j);
        //         }
        //     }
        // }
        
    }

}

//leetcode:
// class Solution {
    
//     // static int n,m;

//     static int[] dx = {-1,0,1,0};
//     static int[] dy = {0,1,0,-1};

//     // static char[][] grid;

//     // 错误写法：static Queue<char[][]> que;
//     // Java: 用 int[2] 表示一对坐标，Queue + LinkedList 实现
//     // C++: queue<pair<int,int>> q;


//     public static int numIslands(char[][] grid){
//         int n =grid.length;
//         int m = grid[0].length;
//         int a = 0;
//         for(int i = 0;i < n;i++){
//             for(int j = 0;j < m;j++){
//                 if(grid[i][j] == '1'){
//                     a++;
//                     bfs(grid,i,j);
//                 }
//             }
//         }
//         return a;
//     }

//     static void bfs(char[][] grid,int x,int y){
//         Queue<int[]> que = new LinkedList<>();

//         //记下坐标
//         que.offer(new int[]{x,y});

//         //入队后标记为'0',表示已经遍历过该'陆地'
//         grid[x][y] = '0';

//         while(!que.isEmpty()){
//             //取出队首元素
//             int[] t = que.poll();

//             //广搜的过程
//             for(int i = 0;i < 4;i++){
//                 //横坐标
//                 int a = t[0] + dx[i];
//                 //纵坐标
//                 int b = t[1] + dy[i];
//                 //越界
//                 if(a < 0||a >= grid.length||b < 0||b >= grid[0].length){
//                     continue;
//                 }
//                 //是“海洋”/已经标记过了
//                 if(grid[a][b] == '0'){
//                     continue;
//                 }

//                 //将遍历到的元素加入到队列中
//                 grid[a][b] = '0';
//                 que.offer(new int[]{a,b});
//             }
//         }
//     }
// }