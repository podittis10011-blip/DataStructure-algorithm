#include<iostream>
#include<cstring>
#include<algorithm>
#include<queue>
using namespace std;

const int N=1010;
int n,m;
char g[N][N];
int dx[8]={-1,-1,-1,0,1,1,1,0};
int dy[8]={-1,0,1,1,1,0,-1,-1};

void bfs(int x,int y){
  queue<pair<int,int>> q;
  q.push({x,y});
  g[x][y]='.';                 // 入队即标记，避免重复入队
  while(q.size()){
    auto t=q.front();q.pop();
    for(int i=0;i<8;i++){
      int a=t.first+dx[i],b=t.second+dy[i];
      if(a<0||a>=n||b<0||b>=m)continue;
      if(g[a][b]=='.')continue;
      g[a][b]='.';             // 先标记再入队
      q.push({a,b});
    }
  }
}

int main(){
  cin >> n >> m;
  for(int i=0;i<n;i++)
    scanf("%s",g[i]);
  int ans=0;
  for(int i=0;i<n;i++)
    for(int j=0;j<m;j++)
      if(g[i][j]=='W')
        ans++, bfs(i,j);
  cout << ans << endl;
  return 0;
}
