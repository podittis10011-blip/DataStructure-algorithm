#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

//10的二十次方是多少位？
const int N = 100010;
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
        B[lb - 1 - j] = b[j] - '0';
    }

    //比较出A、B的大小，如果A<B,直接先输出一个负号"-"
    //la、lb
    //
    if(comp(A,B)){
        //执行交换操作
        swap(A,B);
        //输出负号
        // printf("-");
        cout <<'-';
    }

    //默认a-b
    HighAccuracy_Sub(A,B,C);

    //打印操作：
    for(int i = lc - 1;~i;i--){
        printf("%d",C[i]);
    }

    return 0;
}

//Ai_ans
// #include <cstdio>
// #include <cstring>
// #include <iostream>
// #include <algorithm>

// using namespace std;

// const int N = 100010;
// string a, b;
// int la, lb, lc;
// int A[N], B[N], C[N];

// // 判断 A < B
// bool comp(int A[], int B[]) {
//     if (la != lb) return la < lb;

//     for (int i = la - 1; i >= 0; i--) {
//         if (A[i] != B[i]) {
//             return A[i] < B[i];
//         }
//     }
//     return false;
// }

// // 高精度减法
// void HighAccuracy_Sub(int A[], int B[], int C[]) {
//     for (int i = 0; i < lc; i++) {
//         // 如果当前位不够减，借位
//         if (A[i] < B[i]) {
//             A[i + 1]--;
//             A[i] += 10;
//         }
//         C[i] = A[i] - B[i];
//     }

//     // 去掉前导零
//     while (lc > 1 && C[lc - 1] == 0) {
//         lc--;
//     }
// }

// int main() {
//     cin >> a >> b;

//     la = a.size();
//     lb = b.size();
//     lc = max(la, lb);

//     // 字符串 → 数组（倒序存）
//     for (int i = 0; i < la; i++) {
//         A[i] = a[la - 1 - i] - '0';
//     }
//     for (int i = 0; i < lb; i++) {
//         B[i] = b[lb - 1 - i] - '0';
//     }

//     // 判断是否为负数
//     bool negative = false;
//     if (comp(A, B)) {
//         negative = true;

//         // 手动交换数组
//         for (int i = 0; i < N; i++) {
//             swap(A[i], B[i]);
//         }
//         swap(la, lb);
//     }

//     // 做减法
//     HighAccuracy_Sub(A, B, C);

//     // 输出负号
//     if (negative) cout << "-";

//     // 输出结果（从高位到低位）
//     for (int i = lc - 1; i >= 0; i--) {
//         cout << C[i];
//     }

//     return 0;
// }