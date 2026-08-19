package backtracking.leetcode_39;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int n,target;

    //整数数组
    static int[] candidates;

    //结果数组
    static ArrayList<Integer> path;

    //结果集数组
    static List<List<Integer>> result;

    static void backtracking(int[] candidates,int target,int sum,int startIndex){
        if(sum > target){
            return;
        }

        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex;i < candidates.length;i++){
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            //回溯，删除ArrayList存储的最后一个元素
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates,int target){
        result.clear();
        path.clear();

        backtracking(candidates,target,0,0);
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        target = sc.nextInt();
        candidates = new int[n];

        //初始化结果数组和结果集数组
        path = new ArrayList<Integer>();
        result = new LinkedList<List<Integer>>();

        //初始化数组
        for(int i = 0;i < n;i++){
            candidates[i] = sc.nextInt();
        }

        for(List<Integer> ans : combinationSum(candidates, target)){
            for(int i : ans){
                System.out.print(i + " ");
            }   
            System.out.println();
        }

    }
}
