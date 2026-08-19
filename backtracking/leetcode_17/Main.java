package backtracking.leetcode_17;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    //创建字符串数组存储电话号码数字对应的字母集合ListletterMap
    static final String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    //创建动态数组result存储结果集
    static ArrayList<String> result;

    //符合调节的结果
    static StringBuilder s;

    //输入
    static String digits;

    static List<String> letterCombinations(String digits){
        if(digits.length() == 0){
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    public static void backtracking(String digits,int index){
        if(index == digits.length()){
            result.add(s.toString());
            return;
        }

        //这一部分是为了完成从数字-字母集的映射
        //将字符串digits转换成字符数组，取出索引为index的字符赋值给digit
        // int digit = digits.toCharArray()[index];
        //取数字对应的字符集
        // String letters = letterMap[digit + 1];

        int digit = digits.charAt(index) - '0';
        String letters = letterMap[digit];


        for(int i = 0;i < letters.length();i++){
            s.append(letters.toCharArray()[i]);
            backtracking(digits,index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {

        //初始化保存结果的StringBuilder s
        s = new StringBuilder();

        //初始化结果集
        result = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        digits = sc.next();

        for(String ans : letterCombinations(digits)){
            System.out.print(ans + " ");
        }
        
        

        // letterMap = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // letterMap[10] = {"","","abc", 
        // "def", 
        // "ghi",
        // "jkl",
        // "mno",
        // "pqrs",
        // "tuv", 
        // "wxyz"};  
    }
}
