package doublePointer.luogu_1496;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    static int n,st,ed,sum;

    static class Line implements Comparable<Line>{
        public int l,r;

        public Line(){

        }
        public Line(int l,int r){
            this.l = l;
            this.r = r;
        }

        // @Override
        // public int compareTo(line t){
        //     return l < t.l;
        // }

        @Override
        public int compareTo(Line t){
            return Integer.compare(this.l, t.l);
        }
    }

    static Line[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new Line[n + 1];

        for(int i = 1; i <= n;i++){
            // a[i].l = sc.nextInt();
            // a[i].r = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            a[i] = new Line(l,r);
        }

        // for(int i = 1; i <= n - 1;i++){
        //     Arrays.sort(a,1,n + 1);
        // }
        Arrays.sort(a,1,n + 1);

        st = a[1].l;ed = a[1].r;
        sum += ed - st;
        for(int i = 2; i <= n;i++){
            if(a[i].l < ed){
                //覆盖
                if(a[i].r < ed){
                    continue;
                }
                //重叠
                else{
                    st = ed;
                    ed = a[i].r;
                    sum += ed -st;
                }
            }
            //相离
            else{
                st = a[i].l;
                ed = a[i].r;
                sum += ed - st;
            }
        }
        System.out.print(sum);
    }
}
