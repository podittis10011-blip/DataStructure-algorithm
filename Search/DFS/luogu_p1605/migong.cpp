#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;


// const int N = 5;
const int N = 6;

int n,m,t;
int sx,sy,fx,fy;
int res;

//障碍物坐标


//数组初始化二维迷宫
int migong[N][N];

// int dx[] = {0,1,0,-1};
// int dy[] = {1,0,-1,0};
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};


//a,b接收初始坐标，代表当前坐标位置
void dfs(int a,int b){
    if(a == fx && b == fy){
        res++;
    // continue;
        return;
    } 

    //当前坐标位置等于终点坐标位置时，continue
    // for(int i = 1; i <= 4;i++){
    for(int i = 0; i < 4;i++){
        

        //越界
        // if(a < 1||a > N||b <1||b > N){
        int na =  a + dx[i];
        int nb= b + dy[i];
        if(na < 1 || na > n||nb < 1|| nb > m){
            //continue;
            // return;
            continue;
        }
        //遇到障碍物
        if(migong[na][nb] == 1){
            //continue;
            // return;
            continue;
        }
        //标记已经走过
        migong[na][nb] = 1;
        dfs(na,nb);

        //回溯恢复现场
        migong[na][nb] = 0;
        
    }
}

int main(){
    cin >> n >> m >> t;
    cin >> sx >> sy >> fx >> fy;

    res = 0;
    //初始化迷宫地图(障碍)
    for(int i = 1;i <= t;i++){
        int x,y;
        cin >> x >> y;

        //1代表该处有障碍物
        migong[x][y] = 1;
    }

    migong[sx][sy] = 1;

    //
    dfs(sx,sy);

    cout << res;
    return 0;
}