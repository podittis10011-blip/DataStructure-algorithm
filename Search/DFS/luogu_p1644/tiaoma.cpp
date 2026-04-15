#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;


//问题分析：
//起始点（左下角）——>终止点（右上角）

//
int n, m;
int total;
int dx[4] = {2,1,-1,-2};
int dy[4] = {1,2,2,1};

const int N = 20;

// int qipan[N][N];

void dfs(int a,int b){

    //上来先检查是否匹配
    if(a == n && b == m){
        total ++;
        return;
    }
    for(int i = 0;i < 4;i++){
        int x = a + dx[i];int y = b + dy[i];

        //检查是否越界
        // if(x < 1 || x > n || y < 1 || y > m){
        if(x < 0||x > n||y>m){
            continue;
        }
        dfs(x,y);
    }
}


int main(){
    total = 0;
    cin >> n >> m;

    // qipan[n][m];

    dfs(0,0);

    cout << total;
    return 0;
}