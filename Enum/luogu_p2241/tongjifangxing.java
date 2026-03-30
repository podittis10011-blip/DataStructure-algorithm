package Enum.luogu_p2241;
// import java.util.Scanner;

// class tongjifangxing{
//     // long n,m;
//     // long changfangxing,zhengfangxing;

//     public static void main(String args[]){
//         long n,m;
//         long changfangxing = 0,zhengfangxing = 0;
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextLong();
//         m = sc.nextLong();

//         for(long h = 1;h <= n;h++){
//             for(long w = 1;w <= m;w++){

//                 long count = (n - h + 1) * (m - w + 1);

//                 if(h == w){
//                     zhengfangxing += count;
//                 }
//                 else{
//                     changfangxing += count;
//                 }


//             }
//         } 
//                 System.out.print(zhengfangxing);
//                 System.out.print(" ");
//                 System.out.print(changfangxing);
//                 // System.out.println(zhengfangxing + " " + changfangxing);

//     }


// }
import java.util.Scanner;
class Main{
    // long n,m;
    // long changfangxing,zhengfangxing;

    public static void main(String args[]){
        long n,m;
        long changfangxing = 0,zhengfangxing = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        m = sc.nextLong();

        for(long h = 1;h <= n;h++){
            for(long w = 1;w <= m;w++){

                long count = (n - h + 1) * (m - w + 1);

                if(h == w){
                    zhengfangxing += count;
                }
                else{
                    changfangxing += count;
                }


            }
        } 
                System.out.print(zhengfangxing);
                System.out.print(" ");
                System.out.print(changfangxing);
                // System.out.println(zhengfangxing + " " + changfangxing);

    }


}