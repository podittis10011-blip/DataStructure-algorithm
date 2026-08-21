package greedy.luogu_2512;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a;
    static long[] c;
    // static int[] c;
    static long b,ans;

    public static void main(String[] args) throws IOException {
        // FastScanner fs = new FastScanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n = sc.nextInt();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        a = new int[n + 1];
        c = new long[n + 1];


        for(int i = 1; i <= n;i++){
            a[i] = Integer.parseInt(st.nextToken());
            b += a[i];
        }
        b /= n;

        for(int i = 2;i <= n;i++){
            c[i] = c[i - 1] + a[i - 1] - b;
        }

        Arrays.sort(c,1,n + 1);

        for(int i = 1;i <= n;i++){
            ans += Math.abs(c[i] -c[(n + 1)/2]);
        }
        System.out.print(ans);
    }
}
