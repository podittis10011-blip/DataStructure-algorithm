#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 30;

int n,ans;
int pos[N],c[N],p[N],q[N];

void print(){
    if(ans <= 3){
        for(int i = 1;i <= n;i++)
            printf("%d",pos[i]);
        puts("");
        
    }
}

void dfs(int i){
    
    //有点类似于枚举实现指数型枚举
    if(i > n){
        ans ++;
        print();
        return;
    }
    for(int j = 1;j <= n;j++){
        if(c[j]||p[i + j]||q[i - j + n]){
            continue;
        }
        pos[i] = j;
        c[j] = p[i + j] = q[i - j + n] = 1;
        dfs(i + 1);
        c[j] = p[i+j] = q[i - j + n];
    }

    

}

int main(){
    cin >> n;
    dfs(0);
    cout << ans;
    return 0;
}