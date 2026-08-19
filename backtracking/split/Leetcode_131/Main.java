package backtracking.split.Leetcode_131;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static String s;

    //结果集
    static ArrayList<List<String>> result;

    //结果
    static ArrayList<String> path;

    static void backtracking(String s,int startIndex){
        if(startIndex >= s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }
        for(int i = startIndex;i < s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }else{
                continue;
            }
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    static boolean isPalindrome(String s,int start,int end){
        for(int i = start,j = end;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        result = new ArrayList<List<String>>();

        path = new ArrayList<String>();

        for(List<String> ans : partition(s)){
            for(String s : ans){
                System.out.print(s + " ");
            }
            System.out.println();
        }



    }
}
