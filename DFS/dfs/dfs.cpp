#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
const int N = 500;

////////////////// DFS计算
int n, m, a, b, c;
vector<int> e[N];

void dfs(int u, int fa){
  // printf("进入%d\n",u);
  for(auto v : e[u]){
    if(v==fa) continue;
    // printf("下走%d\n",u);
    dfs(v, u);
    // printf("上回%d\n",u);
  } 
  // printf("离开%d\n",u);
}
int main(){
  cin>>n>>m;
  for(int i=1;i<=m;i++)
    cin>>a>>b, 
    e[a].push_back(b),
    e[b].push_back(a);
  dfs(1, 0);
  return 0;
}