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
  g[x][y]='.';                 // 入队就标成 '.'，避免同一格被多次入队
  while(q.size()){
    // 解释：取出队首元素 t，并从队列中移除。
    // auto t = q.front(); q.pop(); // C++写法

    // Java实现如下：
    // int[] t = que.poll(); // poll()方法返回并移除队首元素
    // for(int i=0;i<8;i++){
    auto t=q.front();q.pop();
    for(int i=0;i<8;i++){
      int a=t.first+dx[i],b=t.second+dy[i];
      if(a<0||a>=n||b<0||b>=m)continue;
      if(g[a][b]=='.')continue;
      g[a][b]='.';
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
