package doublePointer.Leetcode_3;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    
    static String s;
    // static char[] ca;
    static Map<Character,Integer> map;

    static int length;

    static public int lengthOfLongestSubstring(String s) {
 
        map = new HashMap<>();

        int l = 0;


        for(int r = 0;r < s.length();r++){
            char c = s.charAt(r);

            //判断当前窗口中是否包含r指针指向的元素
            if(map.containsKey(c)){
                l = Math.max(l, map.get(c) + 1);
            }

            //更新字符最近出现的位置
            map.put(c, r);

            //更新最长字串的长度
            length = Math.max(length,r - l + 1);
        }
        
        return length;

    }

    public static void main(String[] args) {
        // ca = s.toCharArray();
        Scanner sc = new Scanner(System.in);
        s = sc.next();

        length = 0;

        System.out.println(lengthOfLongestSubstring(s));
    }
}
