package Stack.leetcode_20;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static char[] sa;
    static String s; 

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        sa = s.toCharArray();
        for(int i = 0; i < s.length();i++){

            if(sa[i] == '('){
                st.push(')');
            }
            else if(sa[i] == '['){
                st.push(']');
            }
            else if(sa[i] == '{'){
                st.push('}');
            }
            else if(st.empty() || st.peek() != sa[i]){
                return false;
            }
            else{
                st.pop();
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        s = sc.next();

        System.out.println(isValid(s));
    }
}
