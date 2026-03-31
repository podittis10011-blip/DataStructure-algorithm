#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int n;

const int N = 10010;
const int INF = 10000010;
int arr[N];
//用一个数组存

//问题分析：
//1~N中有多少个按照递增序列进行排序的连续的数列——“连号区间”
//只需要判断L~R的这个区间中，最大的数减去最小的数是否等于他们的间隔
//maxValue存储最大值
//minValue存储最小值

//两层for循环，
    

int main(){

    //输入部分：
    cin >> n;
    for(int i = 1;i <= n;i++ ){
        cin >> arr[i];
    }

    int count = 0;

    //枚举
    //j代表终止元素R
    //i代表起始元素L
    // for(int j = 1;j <= n;j++){
    //     for(int i = 1;i <= j;i++){
    //         //max()、min()函数怎样从指定数组序列中选出最大值和最小值？
    //         int maxValue = max(arr[i],arr[j]);
    //         int minValue = min(arr[i],arr[j]);

    //         //这种方式不可行，max(),min() 函数只能比较两个数

            // if(maxValue - minValue == j - i){
            //     count ++;
            // }
            
    //     }
    // }

    //maxValue = max(arr[i],arr[i + 1])
    //minValue = min(arr[i],arr[i + 1])

    //ans:
    //i为起始位置，j为终止位置
    //
    for(int i = 1;i <=n;i++){
        int minValue = INF;
        int maxValue = -INF;
        //j必须到底吗？
        for(int j = i;j <= n;j++){
            minValue = min(arr[j],minValue);
            maxValue = max(arr[j],maxValue);

            if(maxValue - minValue == j - i){
                count ++;
            }
        }
    }


    
    // cout << count;
    cout << count <<endl;

    return 0;
}
