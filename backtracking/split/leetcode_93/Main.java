package backtracking.split.leetcode_93;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static ArrayList<String> result;

    static String s;

    static void backtracking(String s, int startIndex, int pointNum) {
        // if (pointNum == 3) { // 逗点数量为3时，分隔结束
        //     // 判断第四段子字符串是否合法，如果合法就放进result中
        //     if (isValid(s, startIndex, s.length() - 1)) {
        //         result.add(s);
        //     }
        //     return;
        // }
        // for (int i = startIndex; i < s.length(); i++) {
        //     if (isValid(s, startIndex, i)) { // 判断 [startIndex,i] 这个区间的子串是否合法
        //         s.insert(s.begin() + i + 1 , '.');  // 在i的后面插入一个逗点
        //         pointNum++;
        //         backtracking(s, i + 2, pointNum);   // 插入逗点之后下一个子串的起始位置为i+2
        //         pointNum--;                         // 回溯
        //         s.erase(s.begin() + i + 1);         // 回溯删掉逗点
        //     } else break; // 不合法，直接结束本层循环
        // }
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return result; // 算是剪枝了
        backtracking(s, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        result = new ArrayList<String>();

        
    }
}
