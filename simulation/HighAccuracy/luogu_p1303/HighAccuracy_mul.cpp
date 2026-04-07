#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 100010;
string a,b,c;
int A[N],B[N],C[N];
int la,lb,lc;

void mul(int A[],int B[],int C[]){
    for(int i = 0;i < la;i++){
        for(int j = 0;j <lb;j++){
            C[i + j] += A[i] * B[j];
            C[i + j + 1] += C[i + j]/10;
            C[i + j] %= 10;
        }
    }
    while(lc && C[lc] == 0){
        lc --;
    }
}

int main(){
    cin >> a >> b;

    la = a.size();
    lb = b.size();
    // lc = max(la,lb);
    lc = la + lb;

    for(int i = la - 1;~i;i--){
        A[la - i - 1] = a[i] - '0';
    }
    for(int j = lb - 1;~j;j--){
        B[lb -j - 1] = b[j] - '0';
    }

    mul(A,B,C);

    for(int i = lc;~i;i--){
        cout << C[i];
    }
    return 0;
}