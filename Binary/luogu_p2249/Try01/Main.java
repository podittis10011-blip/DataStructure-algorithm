package Binary.luogu_p2249.Try01;

// import java.util.Scanner;

// public class Main {


//     static final int N = 1000010; 
//     static int n,m,q;

//     //
//     static int[] arr = new int[N];

//     public static void main(String[] args) {
        
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();
//         m = sc.nextInt();

//         for(int i = 1;i <= n;i++){
//             arr[i] = sc.nextInt();
//         }

//         for(int i = 1;i <= m;i++){
//             q = sc.nextInt();


//             //最小化查找
//             // int l = 0;int r = n + 1;
//             // while(l + 1 < r){
//             //     int mid = (l + r) >> 1;

//             //     if(arr[mid] >= q){
//             //         r = mid;
//             //     }
//             //     else{
//             //         l = mid;
//             //     }
//             //     // return r;
//             // }
//             // // System.out.print(r + " ");
//             // if(arr[r] == q){
//             //     System.out.print(r + " ");
//             // }
//             // else{
//             //     System.out.print("-1" + " ");
//             // }

            
//             int l = 0, r = n + 1;

//             while (l + 1 < r) {
//                 int mid = (l + r) >> 1;

//                 if (arr[mid] >= q) {
//                     r = mid;
//                 } else {
//                     l = mid;
//                 }
//             }

//             // 必须加边界判断！
//             if (r <= n && arr[r] == q) {
//                 System.out.print(r + " ");
//             } else {
//                 System.out.print("-1 ");
//             }

//         }

//     }


// }


import java.io.*;
import java.util.*;

public class Main {

    static final int N = 1000010;
    static int[] arr = new int[N];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        String[] nums = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(nums[i - 1]);
        }

        String[] query = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int q = Integer.parseInt(query[i]);

            int l = 0, r = n + 1;

            while (l + 1 < r) {
                int mid = (l + r) >> 1;

                if (arr[mid] >= q) r = mid;
                else l = mid;
            }

            if (r <= n && arr[r] == q) {
                sb.append(r).append(" ");
            } else {
                sb.append("-1 ");
            }
        }

        out.println(sb.toString());
        out.flush();
    }
}