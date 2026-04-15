package loop.luogu_p3383;

import java.util.*;
import java.io.*;

public class Main {



    static int n,q,k,num;
    
    static boolean[] st = new boolean[100000010];
    static int[] iszhishu = new int[100000010];

    static void zhishushai01(int n){
        
        int num = 0;
        st[0] = st[1] = true;
        for(int i = 2;i <= n;i++){
            if(!st[i]){
                iszhishu[++num] = i;
            }
            for(int j = 1;j <= num && (long)i * iszhishu[j] <= n;j++){
                st[i * iszhishu[j]] = true;
                if(i % iszhishu[j] == 0){
                    break;
                }
            
            }

        }
    }

    public static void main(String args[]) throws IOException{

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt(); 
        
        zhishushai01(n);

        //埃氏筛法
        for(int i = 1;i <= q;i++){
            k = sc.nextInt();
            // System.out.println(iszhishu[k]);
            bw.write(iszhishu[k] + "\n");
            bw.flush();
            bw.close();
        }


    }
}


//埃氏筛法
    
    // static int n,q,k,num;
    
    // static boolean[] st = new boolean[100000010];
    // static int[] iszhishu = new int[100000010];


    // //埃氏筛法
    // static void zhishushai(int n){
    //     num = 0;
    //     st[0] = st[1] = true;
    //     for(int i = 2;i <= n ;i++){
    //         if(!st[i]){
    //             num++;
    //             iszhishu[num] = i;
    //             for(int j = 2*i;j <= n;j += i){
    //                 st[j] = true;
    //             }
    //         }
    //     }
    // }

    // public static void main(String[] args) {
    
    //     Scanner sc = new Scanner(System.in);
    //     n = sc.nextInt();
    //     q = sc.nextInt(); 
        
    //     zhishushai(n);

    //     //埃氏筛法
    //     for(int i = 1;i <= q;i++){
    //         k = sc.nextInt();
    //         System.out.println(iszhishu[k]);
    //     }


    // }

//欧拉筛法