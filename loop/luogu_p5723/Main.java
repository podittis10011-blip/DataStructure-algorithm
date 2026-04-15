package loop.luogu_p5723;

import java.util.*;
import java.io.*;


//Test01:
    //暴力解法：双层循环
public class Main {
        static int zhishuValue,n,num;
        static int L;

        static boolean iszhishu(int n){
            if(n <2){
                return false;
            }
            for(int i = 2;i <= n - 1; i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
        public static void main(String args[]){

            Scanner sc = new Scanner(System.in);
            L = sc.nextInt();
            int i = 1,num = 0;
            zhishuValue = 0;
            while(zhishuValue <= L){
                i ++;
                if(iszhishu(i)){
                    zhishuValue += i;
                    if(zhishuValue <= L){
                        num ++;
                        System.out.println(i);
                    }
                }
            }
            System.out.print(num);
        }
}


//Test02

// public class Main {

//         //数组存储输出的质数
//         //定义一个数计算已经存储的质数的和

//         static int zhishuValue,n,num;
//         static int L;

//         // static int[] zhishu = new int[10]

//         static boolean iszhishu(int n){
//             if(n <2){
//                 return false;
//             }
//             for(int i = 2;i <= n - 1; i++){
//                 if(n % i == 0){
//                     return false;
//                 }
//             }
//             return true;

//         }



//         //质数筛
//         // static void zhishushai(){
//         //     //1~1e5
//         //     boolean[] notzhishu = new boolean[100010];
//         //     int[] zhishu = new int[100010];
//         //     //声明为boolean数组，数值i代表被判断的该数值

//         //     //先将0、1加入列表
//         //     notzhishu[0] = notzhishu[1] = true;
//         //     //先判断是不是质数，不是直接
//         //     // if(notzhishu[]){

//         //     // }
//         //     for(int i = 2;i <= n;i++){

//         //         for(int j = i;j <= n;j += j){

//         //             }
//         //         }
//         //     }
        

//         public static void main(String args[]){

//             Scanner sc = new Scanner(System.in);
//             L = sc.nextInt();

//             int i = 1,num = 0;
//             zhishuValue = 0;
//             while(zhishuValue <= L){
//                 i ++;
//                 if(iszhishu(i)){
//                     // zhishu[] = i;
//                     zhishuValue += i;
                    
//                     if(zhishuValue <= L){
//                         num ++;
//                         System.out.println(i);
//                     }
                    
//                 }
//             }

//             // zhishushai(){

//             // }

//             //i % 2
//             // for(int i = 2;i <= L;i++){
                
//             // }

//             //质数判断
//             // n = sc.nextInt();
//             // iszhishu(n);
//             // for(int i = 0;i <= n;i++){
//             //     if(i < 2){}
//             // }

//             System.out.print(num);
//         }

// }

