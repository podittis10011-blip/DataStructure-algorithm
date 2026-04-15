// #include <cstdio>;
// #include <cstring>;
// #include <iostream>;
// #include <algorithm>;
// #include <vector>

// using namespace std;

// //邻接表实现dfs
// //无向图、有向图
// //基于动态数组实现邻接表

// int n , m;
// int a , b , c;

// const int N = 510;

// //结构体构造邻接表中的节点并使用数组进行存储
// //     结构体名称
// // struct Node{
// //     //结点
// //     int v;
// //     //边权
// //     int w;
// // }e[N];
// //  这里加e[N]的意思是开类型为Node长度为N的数组存储Node吗？

// struct Node{
//     //结点
//     int v;
//     //边权
//     int w;
// };

// vector<Node> e[N];

// void dfs(int u,int fa){

//     //遍历集合e,赋值给变量E
//     for(auto E : e[u]){
//         int v = E.v;
//         int w = E.w;

//         //子节点、父节点相同
//         if(v == fa){
//             // return;
//             continue;
//         }
//         printf("%d,%d,%d\n",u,v,w);
//         dfs(v,u);
//     }

// }

// int main(){
//     cin >> n >> m;

//     //建图
//     for(int i = 1;i <= m;i++){
//         cin >> a >> b >> c;
//         e[a].push_back({b,c});
        
//         //无向图
//         e[b].push_back({a,c});
//     }
//     dfs(1,0);
//     return 0;
// }

#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

const int N=510;
int n,m,a,b,c;
struct edge{int v,w;};
vector<edge> e[N];//边集 

void dfs(int u,int fa){
  for(auto ed : e[u]){
    int v=ed.v, w=ed.w;
    if(v==fa) continue;
    printf("%d,%d,%d\n",u,v,w);
    dfs(v, u);
  } 
}
int main(){
  cin>>n>>m;
  for(int i=1;i<=m;i++){ 
    cin>>a>>b>>c,
    e[a].push_back({b,c});
    // e[b].push_back({a,c});
  }
  dfs(1, 0);
  return 0;
}
