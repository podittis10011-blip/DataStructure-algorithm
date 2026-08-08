package doublePointer.luogu_p1381;
import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Main{
    static int n,m;
    static String[] text;
    static HashMap<String,Boolean> wordtable;
    static HashMap<String,Integer> count;
    static int sum,len;
    static String s1;
    // static String[] text

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 初始化单词表
        n = sc.nextInt();

        //初始化HahMap
        wordtable = new HashMap<String,Boolean>();
        count = new HashMap<String,Integer>();

        for(int i= 1;i <= n;i++){
            s1 = sc.next();
            wordtable.put(s1, true);
        }

        m = sc.nextInt();

        //要求从索引1开始，n + 1防止数组越界
        text = new String[m + 1];

        //j++,似乎是不断地扩展课文窗口，然后在当前课文窗口区间下，使用贪心思想，找出当前的局部最优解
        for(int j = 1,i = 1;j <= m;j++){
            text[j] = sc.next();

            //如果课文新扩展窗口包含的右端指针指向的单词属于单词表，那么当前区间单词该单词的出现次数count++,进行对该单词数量进行标记
             if(wordtable.containsKey(text[j])){
                
                // 在Java中如何指定HashMap对应的Key执行自增操作？
                // count.put(text[j], value + 1);

                // 写法一：
                // count.merge(text[j], 1, Integer :: sum);
                // 写法一（lambda表达式）：
                // 
                // import java.util.function.BiFunction;
                // // 将 Lambda 替换为匿名内部类
                // map.merge(key, 1, new BiFunction<Integer, Integer, Integer>() {
                //     @Override
                //     public Integer apply(Integer oldValue, Integer newValue) {
                //         // 这里的逻辑和 Lambda 体完全一致
                //         return oldValue + newValue;
                //     }
                // });
                                
                // 写法二：
                if(count.containsKey(text[j])){
                    Integer oldValue = count.get(text[j]);
                    count.put(text[j],oldValue + 1);
                }else{
                    count.put(text[j],1);
                }
            }

            //如果该单词表中的单词第一次出现，sum++
            // if(count.get(text[j])==1){
            // ChatGPT_error01:
            if(count.containsKey(text[j]) && count.get(text[j])==1){
                sum++;
                len = j - i + 1; 
            }
            while(i <= j){
                // ChatGPT_error03:
                // if(count.get(text[i]) == 1){
                if(count.containsKey(text[i]) && count.get(text[i]) == 1){
                    break;
                }
                // if(count.get(text[i]) >= 2){
                // ChatGPT_error02:
                if(count.containsKey(text[i]) && count.get(text[i]) >= 2){
                    Integer oldValue = count.get(text[i]);
                    count.put(text[i],oldValue - 1);
                    i++;
                }
                if(!wordtable.containsKey(text[i])){
                    i++;
                }
            }
            len = Math.min(len,j - i + 1);

            
        }
        System.out.println(sum);
        System.out.println(len);

    }
}

// ---
// import java.util.*;

// //单词表——set（Hashset）
// //课文——article(String[])
// //滑动窗口中记录各个单词表中需要背的单词出现的次数——cnt(HashMap)

// public class Main {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         //目标单词集合
//         //相当于单词表，初始化需要背的单词
//         HashSet<String> set = new HashSet<>();
//         for(int i = 0; i < n; i++){
//             set.add(sc.next());
//         }
//         int m = sc.nextInt();
//         //article相当于存储课文的字符串数组
//         String[] article = new String[m];
//         for(int i = 0; i < m; i++){
//             article[i] = sc.next();
//         }

//         //为什么目标单词/需要背的单词要用Hashset进行存储，
//         //但是课文中的单词直接使用字符串数组就可以进行存储？



//         //窗口中单词出现次数
//         HashMap<String,Integer> cnt = new HashMap<>();
//         int left = 0;
//         //当前窗口包含多少种目标单词
//         //当前窗口中包含的单词表中单词的数量
//         int have = 0;
//         //最大包含数量
//         //滑动窗口中包含的单词一直在变化，用一个max值计数这个过程中出现的包含单词表中最多单词的一种情况
//         int max = 0;
//         //最短长度
//         //最短长度取了一个很大的初始值，方便后期对该值进行覆盖
//         int ans = Integer.MAX_VALUE;

//         for(int right = 0; right < m; right++){

//             String word = article[right];


//             //加入右端点
//             if(set.contains(word)){

//                 cnt.put(word,
//                         cnt.getOrDefault(word,0)+1);


//                 if(cnt.get(word)==1){
//                     have++;
//                 }
//             }



//             /*
//              * 收缩窗口
//              *
//              * 删除：
//              * 1.不是目标单词
//              * 2.目标单词但是数量超过1
//              */
//             while(left <= right){

//                 String lword = article[left];


//                 if(!set.contains(lword)){
//                     left++;
//                 }
//                 else if(cnt.get(lword)>1){

//                     cnt.put(lword,cnt.get(lword)-1);
//                     left++;

//                 }
//                 else{
//                     break;
//                 }

//             }



//             //更新答案

//             if(have > max){

//                 max = have;
//                 ans = right-left+1;

//             }
//             else if(have == max){

//                 ans = Math.min(ans,right-left+1);

//             }


//         }
//         System.out.println(max);
//         System.out.println(ans);
//     }
// }