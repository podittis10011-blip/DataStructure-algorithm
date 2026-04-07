#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int n;

const int N = 100010;

//两个数组，数组a和数组b
int a[N];
int b[N];

void msort(int l ,int r){
    //开区间

    //分
    if(l == r){
        return;
    }
    int mid = (l + r) / 2; 
    msort(l,mid);
    msort(mid + 1,r);

    //合并操作

    //进行比较
    // int i = l;
    // int j = mid + 1;

    // //i和j的作用是作为指针
    // //k的作用是什么？
    // //暂存l？
    // // int k = l;
    // while(l < mid&& j < r){
    //     if(a())
    // }
//--------------------------------------------------------
//     //合并操作
//     //开区间
//     //i、j作为分治之后的指针
//     int i = 0;
//     int j = mid + 1;
//     int k = l;
//     //
//     while(i < mid&&j < r){
//         if(a[i] > a[j]){
//             b[i] = a[j];
//         }
//         else{
//             b[i] = a[i];
//         }
//         i++;
//         j++;
//     }

//     while(a[i + 1] != 0){
//         b[i++] = a[i + 1];
//     }
//     while(a[j + 1] !=0){
//         b[i++] = a[j + 1];
//     }
//     for(int i = 0;i <= n - 1;i++){
//         a[i] = b[i];
//     }
// }
//--------------------------------------------------

    //合并操作
    int i = l;
    int j = mid + 1;
    int k = l;

    //比较
    while(i <= mid&&j <= r){
        if(a[i] <= a[j]){
            b[k++] = a[i++];
        }else{
            b[k++] = a[j++];
        }
    }

    while(i <= mid){
        b[k++] = a[i++];
    }
    while(j <= r){
        b[k++] = a[j++];
    }
    // for(int i = 1;i <= n - 1;i++){
    //     a[i]  = b[i];
    // }
    for(int i = l;i <= r;i++){
        a[i] = b[i];
    }

}


int main(){
    for(int i = 0;i <= n - 1;i++){
    cin >> a[i];
    }

    msort(0,n -1);

    for(int i = 0;i <= n - 1;i++){
    cout << a[i];
    }
}