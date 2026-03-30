#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

// const int  N = 100000;
// int n;

// int main(){

//     cin >> n;

//     for(int i = 1;i <= n;i++){
//         int mowei = i % 10; 

//         if(mowei % 2 == 0){

            
//         }

//     }

//     return 0;
// }


int n;

// int Ishaoshu(){


// }

int main(){
    cin >> n;
    int haoshu = 0;

    for(int i = 1;i <= n;i++){
        int num = i;

        //从奇数位1开始
        int weishu = 1;

        bool Ishaoshu = true;
        while(num){
            int mowei = num % 10;
            num /= 10;

            //奇数位
            if(weishu % 2 != 0 && mowei %2== 0)
                Ishaoshu = false;
                return;
            //偶数位
            if(weishu % 2 == 0 && mowei % 2 != 0)
                Ishaoshu = false;
                return;
            weishu ++;
        } 
        if(Ishaoshu == true){
            haoshu ++;
        }

    }

    return 0;
}