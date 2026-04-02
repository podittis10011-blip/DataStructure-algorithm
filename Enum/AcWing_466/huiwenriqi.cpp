#include <cstdio>
#include <cstring>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int data1,data2;
int year1,year2;
int yue1,yue2;
int day1,day2;
//直接在data1~data2之间进行枚举
//先枚举年份
//倒序，判断是否回文
//最后判断日期是否合法
//1、3、5、7、8、10、12——31
//4、6、8、9、11——30
//平年，2 —— 28
//闰年，2 —— 29

//倒叙输出的操作

int newdata;
// void check(){
//  if(newyear < year2){
//      if(newmonth <= 12){
//          if(newmonth == 1)
//      }
//      
//  }
//
//  if(new year == year2){
//}
//  if( newyear <= year2 && newyue <= yue2 && newday <= day2){
//  }

// }

int main(){
    cin >> data1;
    cin >> data2;
    // scanf("%d\n%d",data1,data2);

    //节选整形的前四位
    year1 = data1 / 10000;
    year2 = data2 / 10000;

    yue1 = data1 % 10000 /100;
    yue2 = data2 % 10000 /100;
    day1 = data1 % 100;
    day2 = data2 % 100;
    
    printf("%d\n%d\n%d\n%d",year1,year2,yue1,day1);

    for(int i = year1;i <= year2;i++){
        //整型year1 ——>字符串类型stryear1
        // std::string stryear1 = std :: to_string(year1);
        // std::string rvsyear1 = std :: reverse(stryear1.begin(),stryear1.end());
        // string strnewyear1 = stryear1 + rvsyear1;

    
    }


return 0;
}
