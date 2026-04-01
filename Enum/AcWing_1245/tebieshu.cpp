#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

int n;

//字符串——>数字
//%10
///10

//只要包含2、0、1、9其中的一项便可作为“特别数”
//最后还要将这些相加

int main(){
    cin >> n;
    int res = 0;
    for(int i = 1;i <= n;i++){
        int num = i;
        while(num){
            int mowei = num % 10;

            if(mowei == 2||mowei == 0||mowei == 1||mowei == 9){
                res += i;

                //为什么不能使用return语句，跳出本次循环
                // return;

                //可以使用break吗，break;与return;的区别是什么？
                break;
            }

            num /= 10;
        }

    }
    cout << res <<endl;
    return 0;

}