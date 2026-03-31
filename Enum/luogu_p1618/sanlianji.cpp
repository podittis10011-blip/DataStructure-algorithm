#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int A,B,C;

//没有考虑到1~9中每个数值不能重复

int main(){
    cin >> A >> B >> C;

    bool found = false;

    for(int Avalue = 123;Avalue <= 987;Avalue++){
        //数据类型是int,B/A得到的是一个整数，误差错误
        // int Bvalue = Avalue * (B / A);
        // int Cvalue = Avalue * (C / A); 
        int Bvalue = Avalue * B / A;
        int Cvalue = Avalue * C / A;

        //引入：检查1~9是否存在重复的数值、
        string s = to_string(Avalue) + to_string(Bvalue) + to_string(Cvalue);
        sort(s.begin(),s.end());

        if(s == "123456789"){
            cout << Avalue << " " << Bvalue << " " << Cvalue << endl; 
            found = true;
        }


        // if(Avalue,Bvalue,Cvalue <= 987){
        //     cout << Avalue << Bvalue << Cvalue << endl;
        //     // printf(" ");
        // }
    }

    if(!found) cout << "NO!" << endl;

    return 0;
}
