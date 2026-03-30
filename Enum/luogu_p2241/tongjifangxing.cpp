#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

long long n,m;
// int h,w;
long long changfangxing,zhengfangxing = 0;

int main(){
    cin >> n >> m;

    for(long long h = 1;h <= n;h++){
        for(long long w = 1;w <= m;w++){
            long long count = (n - h + 1) * (m - w + 1);
            

            //question1:
                //判定条件
                //当
            if(h == w){
                zhengfangxing += count;
            }
            else
                changfangxing += count;
        }
    }
    cout << zhengfangxing << " " << changfangxing << endl;
    return 0;
}
