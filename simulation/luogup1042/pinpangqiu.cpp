#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;


// const int N = 62510;
// char n[N];
// // string n;
// // char count1[],count2[],totalCount[];

// int main(){
//     cin >> n;
//     // for(int i = 1;i <= n;i++)
//     int i = 1
//     while(char[i] != "E"){
//         cin >> char[i];
//     }
    
//     cout << n <<endl;
    

//     //分两个不同的部分进行打印
//     //部分一

//     //部分二

//     return 0;
// }


//AI_ans
void dayin(const vector<char> & record,int limit){
    int a = 0,b = 0;

    for(char c : record){
        if(c == 'W'){
            a++;
        }
        if(c == 'L'){
            b++;
        }
        // if(c == 'E'){
        //     break;
        // }
        if((a >= limit||b >= limit) && abs(a - b) >= 2){
            cout << a << ":" << b << endl;

            //将a和b重新初始化是因为还要再进行一轮21赛制
            a = 0;
            b = 0;
        }
    }
    cout << a << ":" << b << endl;
}

int main(){
    //多行输入
    string line;

    vector<char> record;
    //没有输入便中断
    while(getline(cin,line)){
        //挨行读取
        for(char c : line){
            // if(c == 'W'){
            //     //索引值++
            //     // record ++;
            // }
            if(c == 'L' || c == 'W'){
                record.push_back(c);
            }
            if(c == 'E'){
                break;
            }
        }
        //如果输入的值为"E",直接跳出while循环
        if(line.find('E') != string :: npos){
                break;
        }

    }
    dayin(record,11);

    printf("\n");

    dayin(record,21);

    return 0;
}