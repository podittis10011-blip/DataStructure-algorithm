package doublePointer.luogu_p1381;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiFunction;

class Main{
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
            if(count.get(text[j])==1){
                sum++;
                len = j - i + 1; 
            }
            while(i <= j){
                if(count.get(text[i]) == 1){
                    break;
                }
                if(count.get(text[i]) >= 2){
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