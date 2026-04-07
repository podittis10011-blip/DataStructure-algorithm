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
    int i = l;
    int j = mid + 1;

    // //i和j的作用是作为指针
    // //k的作用是什么？
    // //暂存l？
    // // int k = l;
    // while(l < mid&& j < r){
    //     if(a())
    // }
}

int main(){
    for(int i = 0;i <= n - 1;i++){
    cin >> a[i];
    }

    msort(0,n -1)
}