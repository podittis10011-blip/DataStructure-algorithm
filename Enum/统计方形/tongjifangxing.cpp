#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int n,m;
int h,w;
int changfangxing,zhengfangxing;

int main(){
    cin >> n >> m;

    for(h = 1;h <= n;h++){
        for(w = 1;w <= m;m++){
            int count = (n - h + 1) * (m - w + 1);
            

            //question1:
                //判定条件
                //当
            if(n - h == m - w){
                zhengfangxing += count;
            }
            else
                changfangxing += count;
        }

        cout << zhengfangxing << " " << changfangxing << endl;
    }
    return 0;
}
