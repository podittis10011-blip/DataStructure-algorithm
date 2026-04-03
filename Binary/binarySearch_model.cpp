#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int n,value;
const int N = 100;
int arr[N];

int binarySearch(int arr[],int target){
    //初始化left和right的值
    int left = 1;
    int right = sizeof(arr)/sizeof(arr[0]);
    while(left < right){
        int mid = (right - left ) / 2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target){
            right = mid - 1;
        }
        else{
            left = mid + 1;
        }
    }
    return -1;
}

int main(){
    cin >> n >> value;

    for(int i = 1;i <= n;i++){
        cin >> arr[i];
    }
    // int arr[] = {3,5,8,99,20,12,28,15,20};

    int res = binarySearch(arr,value);
    cout << res <<endl;
}