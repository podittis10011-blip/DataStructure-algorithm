package backtracking.leetcode_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n,k;

    static LinkedList<Integer> path;

    static ArrayList<LinkedList<Integer>> result;

    static void backtracking( int targetSum,int k, int startIndex,int sum){

        if(path.size() == k){
            //增加符合条件的条件语句
            if(sum == targetSum){
                result.add(new LinkedList<>(path));
            }
            return;
        }

        //只能使用数字1~9
        for (int i = startIndex; i <= 9; i++){
        // for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            sum += i;
            backtracking(targetSum, k, i + 1,sum);
            sum -= i;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        result = new ArrayList<LinkedList<Integer>>();

        path = new LinkedList<Integer>();

        backtracking(n,k,1,0);

        for(LinkedList<Integer> r : result){
            for(int i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
