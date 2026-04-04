#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

// float n,ans;

// float qiugen(float n){
//     int r = 100;
//     int l = -100;
//     while(r - l > 1e-6){
//         float mid = (r + l) / 2;
//         if(mid * mid * mid <= n){
//             l = mid;
//         }
//         else{
//             r = mid;
//         }
//     }
//     return l;
// }

// int main(){
//     // cin >> n;
//     scanf("%.6f",n);

//     int ans = qiugen(n);

//     printf("%.6f",ans);

//     return 0;
// }


double n,ans;

double qiugen(float n){
    double r = 100.0;
    double l = -100.0;
    while(r - l > 1e-7){
        double mid = (r + l) / 2;
        if(mid * mid * mid <= n){
            l = mid;
        }
        else{
            r = mid;
        }
    }
    return l;
}

int main(){
    // cin >> n;
    scanf("%lf",&n);

    ans = qiugen(n);

    printf("%.6lf",ans);

    return 0;
}