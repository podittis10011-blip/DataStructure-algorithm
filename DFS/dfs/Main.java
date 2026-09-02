package DFS.dfs;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> a;
    static int n,m,b,c;


    static void dfs(int u,int fa){
        for(int v : a){
            if(v == fa){
                continue;
            }
            dfs(v,u);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        a =  new ArrayList<Integer>();

        for(int i = 1; i<= m;i++){
            b = sc.nextInt();
            c = sc.nextInt();
            a.add(b);
            a.add(c);
        }

        dfs(1,0);

    }
}
