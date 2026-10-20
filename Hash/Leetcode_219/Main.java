package Hash.Leetcode_219;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.lang.Math;

//这道题最大的问题是，不像之前只用存个数，如果要沿用之前的思路那么还要存储相对位置。
//就算存储了相对位置，还要进行绝对值作差运算

//先构造哈希表
//然后再进行差值运算

public class Main {
    
    static int[] nums;
    static int n,k;

    static public boolean containsNearbyDuplicate(int[] nums, int k) {
        //创建一个Key为：Integer，值为一个存放元素类型为Integer类型的LinkedList链表
        Map<Integer,LinkedList<Integer>> hash= new HashMap<>();

        // Map<Integer,ArrayList<Integer>> hash= new HashMap<>();

        //初始化哈希表
        for(int i = 0;i < n;i++){
            if(hash.get(nums[i]) == null){
                //不存在该键值对，新建键值对和链表放入
                hash.put(nums[i],new LinkedList<>());
                hash.get(nums[i]).add(i);
            }else{
                hash.get(nums[i]).add(i);
            }
        }

        //存在两个相同值的索引，避免重复比较
        //哈希表的遍历操作
        for(Integer key : hash.keySet()){
            
            LinkedList<Integer> list = hash.get(key);

            if(list.size() < 2){
                continue;
            }

            int prev = list.getFirst();

            for(Integer next : hash.get(key)){
                if(next != prev && Math.abs(next - prev) <= k){
                    return true;
                }
                prev = next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        nums = new int[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }


        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
