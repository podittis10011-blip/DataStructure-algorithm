#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

string a,b,c;
int la,lb,lc;
const int N = 510;
int A[N],B[N],C[N];

//Test01:
// void HighAccuracy_add(int A[],int B[],int C[],int weishu){
//     //相加 、进位 
//     //相加的次数？
//     lc = weishu - 1;
//     for(int i =0;i <=  weishu - 1;i++){
//     // for(int i = weishu - 1;~i;i--){
//         //相加
//         //进位
//         C[i + 1] += A[i] + B[i] / 10;
//         //取余
//         C[i] += A[i] + B[i] % 10;
//     }

//     //最终对于最高位更新的处理：
//     if(C[weishu + 1] != 0){
//         lc ++;
//     }
// }

//Test02:
// void HighAccuracy_add(int A[],int B[],int C[]){
//     //相加 、进位 
//     //相加的次数？
//     for(int i =0;i <=  lc - 1;i++){
//     // for(int i = weishu - 1;~i;i--){
//         //相加
//         //进位
//         C[i + 1] += A[i] + B[i] / 10;
//         //取余
//         C[i] += A[i] + B[i] % 10;
//     }

//     //最终对于最高位更新的处理：
//     if(C[lc] != 0){
//         lc ++;
//     }
// }

//Test03:
void HighAccuracy_add(int A[],int B[],int C[]){
    //相加 、进位 
    //相加的次数？
    for(int i = 0;i < lc; i++){
        C[i] += A[i] + B[i];
        C[i + 1] += C[i]/10;
        C[i] %= 10;
    }

    //最终对于最高位更新的处理：
    if(C[lc] != 0){
        lc ++;
    }
}

//Test04:


int main(){
    cin >> a >> b;
    
    //字符串a翻转存入A数组
    // for(int i = ;i;i--)
    //     A[] a[i]

    // for()

    //获取字符串的长度
    la = a.size();
    lb = b.size();
    // lc = c.size();

    //字符串翻转存入数组
    for(int i = la - 1;~i;i--){
        A[i] = a[la - i - 1] - '0';
    }
    for(int j = la - 1;~j;j--){
        B[j] = b[lb - j - 1] - '0';
    }
    lc = max(la,lb);
    // for(int i = 0;i < la;i++){
    //     printf("%d",A[i]);

    // }
    HighAccuracy_add(A,B,C);

    //倒序输出
    for(int k = lc - 1;~k;k--){
        // cout << C[k] <<endl;
        printf("%d",C[k]);
    }
}

