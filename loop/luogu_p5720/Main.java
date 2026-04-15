package loop.luogu_p5720;

import java.util.*;
import java.io.*;

//向下取整
// / >>1

public class Main {
    static int a,date;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        date = 0;

        while(a > 1){
            a = a >> 1;
            date++;
        }

        System.out.print(date + 1);
    }
}
