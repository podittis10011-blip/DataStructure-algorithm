package doublePointer.luogu_p1147;

// import java.util.*;
// import java.io.*;

// public class Main {

//     static int m;

//     public static void main(String agrs[]){

//     //从中间取值


//     Scanner sc = new Scanner(System.in);
//     m = sc.nextInt();

//     int l = 1;
//     // int r = 2*1000010;
//     int r = 1;
//     int sum = 1;
//     while( l <= m/2){
//         if(sum < m){
//             sum += r;
//             ++r;
//         }
//         if(sum >= m){
//             if(sum == m){
//                 System.out.println(l +" "+r);
//                 // continue;
//             }
//             sum -= l;
//             ++l;
//         }
//     }


//     }

// }


import java.util.*;
import java.io.*;

public class Main{
    static int m;
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();

        int l = 1;
        int r = 1;
        int sum = 1;

        while(l <= m >> 1){
            if(sum < m){
                ++r; 
                sum += r;
            }
            if(sum >= m){
                if(sum == m){
                    System.out.println(l + " " + r);
                }
                else{
                    sum -= l;
                    ++l;
                }
            }
            
        }
        
        
    }
    
}