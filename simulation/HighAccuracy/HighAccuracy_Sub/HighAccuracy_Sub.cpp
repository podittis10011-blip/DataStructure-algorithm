#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

//10的二十次方是多少位？
const int N = 1000010;
string a,b,c;
int la,lb,lc;
int A[N],B[N],C[N];

bool comp(int A[],int B[]){
    //先看最大位la是否大于lb
    //如果位数相同
    //再一位位的进行比较，如果两个数值相同位数的数值大小相同，那么继续向下进行比较
    //如果


    if(lb > la){
        return true;
    }
    for(int i = lc - 1;~i;i--){
        if(B[i] > A[i]){
            return true;
        }
    }
    return false;
}

void HighAccuracy_Sub(int A[],int B[],int C[]){
    //相减
    //借位A[i+1]-- A[i] += 10 
    for(int i = 0;i < lc - 1;i++){
        if(B[i] > A[i]){
            A[i + 1]--;
            A[i] += 10;
        }
        C[i] += A[i] - B[i] % 10;
    }
    for(int i = lc - 1;~i;i--){
        if(C[i] == 0){
            lc--;
        }

    }
}

int main(){
    cin >> a >> b;
    la = a.size();
    lb = b.size();
    lc = max(la,lb);

    for(int i = la - 1;~i;i--){
        A[la - 1 - i] = a[i] - '0';
    }
    for(int j = lb - 1;~j;j--){
        B[lb - 1 - j] = a[j] - '0';
    }

    //比较出A、B的大小，如果A<B,直接先输出一个负号"-"
    //la、lb
    //
    if(comp(A,B)){
        //执行交换操作
        swap(A,B);
        //输出负号
        printf("-");
    }

    //默认a-b
    HighAccuracy_Sub(A,B,C);

    //打印操作：
    for(int i = lc - 1;~i;i--){
        printf("%d",C[i]);
    }

    return 0;
}