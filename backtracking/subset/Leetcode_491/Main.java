package backtracking.subset.Leetcode_491;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;;

public class Main {
    static int[] nums;
    static int n;

    static ArrayList<List<Integer>> result;
    static ArrayList<Integer> path;
    // static boolean[] used;

    public static List<List<Integer>> findSubsequences(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    public static void backtracking(int[] nums,int startIndex){
        if(path.size() > 1){
            result.add(new ArrayList<Integer>(path));
        }
        HashSet<Integer> uset = new HashSet<Integer>();
        for(int i = startIndex;i < nums.length;i++){
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1)||uset.contains(nums[i])){
                continue;
            }

            uset.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
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

        for(List<Integer> ans : findSubsequences(nums)){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}