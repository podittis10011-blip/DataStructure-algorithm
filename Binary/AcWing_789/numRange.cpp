#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 100010;

int n,q;
int searchValue;
int arr[N];

// >=
// 最小化
//右侧
int qishi(int arr[],int searchValue,int n){
    //开区间
    int l = -1;
    int r = n;
    while(l + 1 < r){
        int mid = l + r >> 1;
        if(arr[mid] >= searchValue){
            r = mid;
        }
        else{
            l = mid;
        }
    }
    return arr[r] == searchValue ? r : -1;
}

int zhongzhi(int arr[],int searchValue,int n){
    int l = -1;
    int r = n;
    while(l + 1 < r){
        int mid = l + r >> 1;
        if(arr[mid] <= searchValue){
            l = mid;
        }
        else{
            r = mid;
        }
    }
    return arr[l] == searchValue ? l : -1;
}

int main(){
    cin >> n >> q;

    for(int i = 1;i <= n;i++){
        cin >> arr[i];
    }

    for(int j = 1;j <= q;j++){
        cin >> searchValue;
        int qishiValue = qishi(arr,searchValue,n);
        int zhongzhiValue = zhongzhi(arr,searchValue,n);
        cout << qishiValue << zhongzhiValue << endl;
    }

}