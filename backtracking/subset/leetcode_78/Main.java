package backtracking.subset.leetcode_78;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] nums;
    static int n;

    static ArrayList<List<Integer>> result;
    static ArrayList<Integer> path;

    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    public static void backtracking(int[] nums,int startIndex){
        result.add(new ArrayList<Integer>(path));
        if(startIndex >= nums.length){
            return;
        }
        for(int i = startIndex;i < nums.length;i++){
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

        for(List<Integer> ans : subsets(nums)){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}
