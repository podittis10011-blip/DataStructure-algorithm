package Binary.binaryInt;

import java.util.*;

public class Main {

    //开区间
    //<= r 
    //>= l
    static final int N = 100010;
    static int[] a = new int[N];
    static int n,q,k;

    //<= ——> r
    static int minSearch(int t){

        //开区间
        int l = 0;int r = n + 1;
        while(l + 1 < r){
            int mid = (l + r) >> 1;
            if(a[mid] >= t){
                r = mid;
            }else{
                l = mid;
            }
        }
        // return r;

        // if(a[r] == t){
        //     return r;
        // }

        // return -1;

        // return a[r] == t ? r : -1;
        return (r <= n && a[r] == t) ? r : -1;
        

    } 

    //>= ——> l
    static int maxSearch(int t){
        //开区间
        int l = 0;int r = n + 1;
        while(l + 1 < r){
            int mid = (l + r) >> 1;
            if(a[mid]<= t){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        // return l;

        // if(a[l] == t){
        //     return l;
        // }

        // return -1;
        return (l >= 1 && a[l] == t) ? l : -1;
    }

    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // int[] a= new int[N];

        q = sc.nextInt();

        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
           
        }

        for(int i = 1;i <= q;i++){
            //  q = sc.nextInt();

            k = sc.nextInt();
            int qishi = minSearch(k);
            int zhongzhi = maxSearch(k);

            

            // System.out.println(qishi + " " + zhongzhi);
            // System.out.println((qishi > n || a[qishi] != k) ? "-1 -1" : qishi + " " + zhongzhi);
            // if(qishi == -1) {
            // System.out.println("-1 -1");
            // } 
            // else {
            //     System.out.println(qishi + " " + zhongzhi);
            // }

            if(qishi == -1) qishi = zhongzhi = -1;
            else {
            qishi--;
            zhongzhi--;
            }
            System.out.println(qishi + " " + zhongzhi);
            }

    }
}
