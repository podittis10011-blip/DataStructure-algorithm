#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;


//三元组实现思路
//将B中的元素分别与A和C中的元素进行比较
//三层for循环实现
//B先与A进行比较再将B与C进行比较


//使用完全暴力枚举进行求解


//ans:
//使用前缀和进行求解
//以B集合中的一个元素为基准
//计算集合B中任意一个元素，满足小于B的A中的元素及大于B的C中元素的个数
//对于大于以B中该元素为基准的B中的元素，小于B中以该元素为基准的A中的元素均符合要求，同理，集合C中元素也一样

const int N = 100010;
int n;
int arrA[N],arrB[N],arrC[N];
int cnt[N];



int main(){
    cin >> n;

    //输入部分：
    
    //这种输入方式似乎与题中不符
    // for(int i = 1;i <= n;i++){
    //     cin >> arrA[i];
    //     cin >> arrB[i];
    //     cin >> arrB[i];
    // }

    for(int i = 1;i <= n;i++){
        cin >> arrA[i];
    }
    for(int i = 1;i <= n;i++){
        cin >> arrB[i];
    }
    for(int i = 1;i <= n;i++){
        cin >> arrC[i];
    }

    //算法逻辑部分
    //<= B ——> 

    //先计算出A和C的前缀和
    //统计出集合A、C出现的频率

    //考虑到数组中存储的元素个数会重复
    //cnt[arrA[i]]++;
    //cnt[arrC[i]]++;
    //每个数值的前缀和，桶排序
    //以数组B中某个元素b为基准，小的元素全部前缀和，大的元素前缀和

    

    return 0;
}