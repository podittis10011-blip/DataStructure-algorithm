package Hash.Leetcode_49;

import java.util.Scanner;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;

public class Main {
    
    static String[] strs;
    static int n;

    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map= new HashMap<>();

        for(int i = 0; i < strs.length;i++){
            
            //临时数组，并不改变strs中实际存储的字符串，只是将字符串转换为字符数组方便后续进行重排序与哈希表计数
            char[] c = strs[i].toCharArray();

            Arrays.sort(c);

            //重排序完成后再将数组组装成字符串
            String s = new String(c);
            
            //是否包含，包含——value加一,不包含将该元素添加进去
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                // map.put(s, new ArrayList<String>());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
        // Collection<List<String>> values = map.values();
            // values，是map提供的接口方法，用于获取Map中所有的Value
            // [
            //     ["eat", "tea", "ate"],
            //     ["tan", "nat"],
            //     ["bat"]
            // ]
        // List<List<String>> result = new ArrayList<>(values);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        strs = new String[n];

        for(int i = 0; i < n;i++){
            strs[i] = sc.next();
        }

        List<List<String>> Arr = groupAnagrams(strs);

        // for(String s : strs){
        //     System.out.print(s + "");
        // }

        for(List<String> group : Arr){
            System.out.println(group);
        }

    }
}
