package backtracking.combination.leetcode_77;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n,k;
    
    //存放符合条件的结果的集合,path中存储的是组合数
    static LinkedList<Integer> path;

    //存放符合条件的结果集的集合，result存储的是path的合集
    static ArrayList<LinkedList<Integer>> result;

    static void backtracking(int n ,int k, int startIndex){
        if(path.size() == k){
            result.add(new LinkedList<>(path));
            // 到达组合树的叶子节点，返回
            return;
        }

        // 我记得这里可以进行剪枝优化，组合数，按照升序字典序进行排序，
        // 从开始位置进行遍历
        // for(int i = startIndex; i <= n;i++){
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        //初始化result
        result = new ArrayList<LinkedList<Integer>>();

        path = new LinkedList<Integer>();

        //开始遍历的索引位置从1开始
        backtracking(n,k,1);

        for(LinkedList<Integer> r : result){
            for(int i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
