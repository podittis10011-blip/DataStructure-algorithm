#include <cstdio>
#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

string date;

//固定的日期范围
//随机输入待判断日期格式：XX/XX/XX
//推断所有可能的日期：
//年、月、日
//年：1960~2059
    //1~59——>20年代
    //60~99——>19年代
//月：1~12
    //日：1~28；1~30；1~31  

//枚举
//三层for循环
//year
    //平年/闰年
    //month（month放在外层循环——>2再判断平闰年）
        //day

int main(){

    cin >> date;

    // string str = "2002-03-04";
   
    // cout << str << endl;
    // printf("%s",str.c_str());
    return 0;

}