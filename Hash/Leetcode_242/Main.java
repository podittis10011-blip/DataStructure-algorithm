package Hash.Leetcode_242;

import java.util.Scanner;
// import java.util.*;

public class Main {
    static String s,t;
    static int[] hashtable;
    static char[] charArray01,charArray02;

    public static boolean isAnagram(String s,String t){

        hashtable = new int[26];

        //将字符串转换为数组
        charArray01 = s.toCharArray();
        charArray02 = t.toCharArray();
        // for(int i = 0;i < charArray.length;i++){
        //     System.out.println(charArray[i]);
        // }

        if(charArray01.length != charArray02.length){
            return false;
        }

        // for(int i = 0;i < 25;i++){
        //tochayArray()的工作原理是根据字符串切割成字符后的长度新开一个字符数组然后赋值给这个新数组
        for(int i = 0;i < charArray01.length;i++){
            hashtable[charArray01[i] % 97]++;
            hashtable[charArray02[i] % 97]--;
        }


        for(int i = 0;i < hashtable.length;i++){
            if(hashtable[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        t = sc.next();

        // // charArray = new char[25];
        // hashtable = new int[26];

        // charArray01 = s.toCharArray();
        // charArray02 = t.toCharArray();
        // // for(int i = 0;i < charArray.length;i++){
        // //     System.out.println(charArray[i]);
        // // }

        // //将字符串转换为数组

        // // for(int i = 0;i < 25;i++){
        // //tochayArray()的工作原理是根据字符串切割成字符后的长度新开一个字符数组然后赋值给这个新数组
        // for(int i = 0;i < charArray01.length;i++){
        //     hashtable[charArray01[i] % 97]++;
        //     hashtable[charArray02[i] % 97]--;
        // }

        // for(int i = 0;i < hashtable.length;i++){
        //     if(hashtable[i] != 0){
        //         System.out.println(false);
        //         break;
        //     }
        // }
        // System.out.println(true);
        
        System.out.println(isAnagram(s,t));
    }
}
