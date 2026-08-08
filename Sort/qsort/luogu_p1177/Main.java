package Sort.qsort.luogu_p1177;

import java.util.Scanner;

// public class Main {
//     static int n;
//     static int[] a;


//     //l、r分别代表数组的左右两端
//     static void quicksort(int l,int r){
//         int i = l - 1;
//         int j = r + 1;

//         while(i < j){

//         }

//         quicksort(l, i);
//         quicksort(j + 1, r);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();

//         a = new int[n];

//         // for(i)
//     }
// }

public class Main{
    static int n;
    static int[] a;


    //找出基准（每次直接取中间值为基准）
    //小于基准的放左边 大于基准的放右边 
    public static void quicksort(int l,int r){
        if(l == r){return;}
        //将两个指针放在区间外
        // ChatGPT_error01:循环过程中下标x所对应的数值会发生变化
        // int i = l - 1,j = r + 1,x = (i + j) / 2;
        int i = l - 1,j = r + 1,x = a[(l + r) / 2];
        while(i < j){
            do{i++;}while(a[i] < x);
            do{j--;}while(x < a[j]);
            if(i < j){int temp = a[i];a[i] = a[j];a[j] = temp;}
        }
        quicksort(l, j);
        quicksort(j + 1, r);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n;i++){
            a[i] = sc.nextInt();
        }

        quicksort(0, n - 1);

        for(int i = 0; i < n;i++){
            System.out.print(a[i] + " ");
        }
    }
}
