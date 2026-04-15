#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

#include <vector>

using namespace std;

//邻接表实现dfs
//建表
//利用结构体实现节点
//vector<>构建表关系

const int N = 510;
int a,b,c,n,m;
// struct edge{
//     int v;
//     int w;
// }

//动态数组存储......
vector<int> e[N];


//dfs：
//深搜、回溯
void dfs(int u,int fa){

    for(auto v : e[u])
    if(v == fa){
        continue;
    }
    dfs(v,u);
}


int main(){
    // cin >> n >> m;

    cin >> m;

    for(int i = 1;i <= m;i++){
        cin >> a >> b;

        e[a].push_back(b);
        e[b].push_back(a);

    }
    
    dfs(1,0);

    // e<>
    return 0;
}