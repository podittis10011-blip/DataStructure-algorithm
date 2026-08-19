package backtracking.subset.leetcode_90;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] nums;
    static int n;

    static ArrayList<List<Integer>> result;
    static ArrayList<Integer> path;
    // static boolean[] used;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,0,used);
        return result;
    }

    public static void backtracking(int[] nums,int startIndex,boolean[] used){
        result.add(new ArrayList<Integer>(path));
        // if(startIndex >= nums.length){
        //     return;
        // }
        for(int i = startIndex;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1,used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        result = new ArrayList<List<Integer>>();
        path = new ArrayList<Integer>();
        // used = new boolean[n];

        for(List<Integer> ans : subsetsWithDup(nums)){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}

