package backtracking.permutation.leetcode_47;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {
    static int[] nums;
    static int n;

    static ArrayList<List<Integer>> result;
    static ArrayList<Integer> path;
    

    public static  List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return result;
    }

    public static void backtracking(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            if(used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
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

        for(List<Integer> ans : permuteUnique(nums)){
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
    }
}
