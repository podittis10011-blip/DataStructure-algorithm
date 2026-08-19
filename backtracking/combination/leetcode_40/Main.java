package backtracking.combination.leetcode_40;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

    static int n,target;
    static int[] candidates;

    static ArrayList<List<Integer>> result;

    static ArrayList<Integer> path;

    //boolean数组记录是否在同一树层
    // static ArrayList<Boolean> uesd;


    static void backtracking(int[] candidates,int target,int sum,int startIndex,boolean[] used){
        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i < candidates.length&& sum + candidates[i] <= target;i++){
            //对同一树层使用过的元素进行跳过
            if(i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true; 
            backtracking(candidates, target, sum, i + 1, used);
            used[i] = false;
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }

    } 

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        //初始化，并且元素记录均为false
        boolean[] used = new boolean[candidates.length];
        
        //先把candidates排序，让其他相同的元素挨在一起
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0,used);
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        candidates = new int[n];

        for(int i = 0;i < n;i++){
            candidates[i] = sc.nextInt();
        }
        
        target = sc.nextInt();

        result = new ArrayList<List<Integer>>();
        path = new ArrayList<Integer>();

        for(List<Integer> ans : combinationSum2(candidates,target)){
            for(int i : ans){
                System.out.print(i +" ");
            }
            System.out.println();
        }

        
    }
    
}
