#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

// int n,value;
// const int N = 100;
// int arr[N];

// int binarySearch(int arr[],int target){
//     //初始化left和right的值
//     int left = 1;
//     int right = sizeof(arr)/sizeof(arr[0]);
//     while(left <= right){
//         int mid = (right + left ) / 2;
//         if(arr[mid] == target){
//             return mid;
//         }
//         else if(arr[mid] > target){
//             right = mid - 1;
//         }
//         else{
//             left = mid + 1;
//         }
//     }
//     return -1;
// }

// int main(){
//     cin >> n >> value;

//     for(int i = 1;i <= n;i++){
//         cin >> arr[i];
//     }
//     // int arr[] = {3,5,8,99,20,12,28,15,20};

//     int res = binarySearch(arr,value);
//     cout << res <<endl;
// }

//-------------------------------------------------


//查找最大化取值


//查找最小化取值

int n,value;

//n——>初始化数组长度
//value——>最小化/最大化取值的边界条件
int arr[];

//右侧区域
int zuixiaohua(int arr[],int value,int n){
    //开区间
    int l = 0;
    int r = n + 1;

    // while(l < r + 1){
    while(l + 1 < r){
        int mid = l + r >> 1;
        if(arr[mid] < value){
            // l = mid + 1;
            l = mid;
        }
        else{
            // r = mid - 1;
            r = mid;
        }
    }
    return r;
}

//左侧区域：
int zuidahua(int arr[],int value,int n){
    //开区间
    int l = 0;
    int r = n + 1;

    // while(l < r + 1){
    while(l + 1 < r){
        int mid = (l + r) >> 1;
        if(arr[mid] < value){
            // l = mid + 1;
            l = mid;
        }
        else{
            // r = mid - 1;
            r = mid;
        }
    }
    //只有当 l= r + 1时，循环才会终止
    return l;
    //如果没有找到呢？

}

int resmax_float(int arr[],int value,int n){
    
}

int resmin_float(int arr[],int value,int n){
    
}

int main(){
    printf("输入数组长度，并初始化一个有序数组");
    cin >> n >> value;
    for(int i = 0;i <= n - 1;i++){
        cin >> arr[i];
    }

    // <= value 的最大化索引值
    int resmax = zuidahua(arr,value,n);
    cin >> resmax;

    int resmin = zuixiaohua(arr,value,n);
    cin >> resmin;
}