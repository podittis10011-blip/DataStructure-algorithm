package loop.zhishushai;
import java.util.*;
import java.io.*;

public class Main {
    
    static int n,num;
    
    static boolean[] st = new boolean[100010];
    static int[] iszhishu = new int[100010];

    static void zhishushai(int n){
        num = 0;
        st[0] = st[1] = true;
        for(int i = 2;i <= n ;i++){
            if(!st[i]){
                num++;
                iszhishu[num] = i;
                for(int j = 2*i;j <= n;j += i){
                    st[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        zhishushai(n);

        for(int i = 1;i <= num;i++){
            System.out.println(iszhishu[i]);
        }
    }
}
