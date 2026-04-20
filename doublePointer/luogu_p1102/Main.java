package doublePointer.luogu_p1102;
import java.util.*;
import java.io.*;


public class Main {

    static final int N = 2*100010 + 10;
    static int n,c;
    static int a[] = new int[N];


    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();

        for(int i = 1; i <= n;i++){
            a[i] = sc.nextInt();
        }

        long ans = 0;

        for(int k = 1,i=1,j=1;k<=n;k++){
            while(i<=n && a[i] - a[k] < c){
                i++;
            }
            while(j<=n && a[j] - a[k] <= c){
                j++;
            }
            ans += j - i;
        }

        System.err.println(ans);
    }
    
}
