// package temp_pratice.luogu_p1381;

// import java.util.Scanner;

// public class Main {
//     static String[] wordTable;
//     static String[] text;

//     static int n,m,low,fast,textLength;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         //初始化单词表
//         n = sc.nextInt();
//         wordTable = new String[n + 1];
//         for(int i = 1;i <= n;i++){
//             wordTable[i] = sc.next();
//         }

//         //初始化课文
//         m = sc.nextInt();
//         text = new String[m + 1];
//         for(int j = 1;j <= n;j++){
//             text[j] = sc.next();
//         }

//         while(low < fast){
            
//         }


//     }
// }

// -----
package temp_pratice.luogu_p1381;

import java.io.*;
import java.util.*;

/**
 * P1381 单词背诵 — 滑动窗口
 *
 * 对应 C++ 官方解的直接翻译：
 *   word 集合 ← 单词表中的单词（HashSet，对应 C++ 的 map<string,bool>）
 *   cnt  映射 ← 当前窗口内各目标单词的出现次数（HashMap，对应 map<string,int>）
 *   sum      ← 文章中出现的单词表单词种类数
 *   len      ← 包含最多单词表单词的最短连续段长度
 *
 * 核心逻辑（滑动窗口双指针 i ≤ j）：
 *   右指针 j 每读入一个单词就尝试纳入窗口；
 *   左指针 i 在保证“窗口中至少保留每种出现过的目标单词一份”的前提下尽量右移。
 */
// public class Main {

//     public static void main(String[] args) throws IOException {
//         // ---------- 快速输入 ----------
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

//         // ---------- 读入单词表 ----------
//         int n = Integer.parseInt(br.readLine());
//         Set<String> word = new HashSet<>();          // 对应 C++ map<string,bool>
//         for (int k = 0; k < n; k++) {
//             word.add(br.readLine());
//         }

//         // ---------- 读入文章 ----------
//         int m = Integer.parseInt(br.readLine());
//         String[] s = new String[m];                   // 对应 C++ s[100005]

//         Map<String, Integer> cnt = new HashMap<>();   // 对应 C++ map<string,int>
//         int sum = 0;                                   // 出现过的目标单词种类数
//         int len = Integer.MAX_VALUE;                   // 最短连续段长度

//         // i 是窗口左边界，j 是窗口右边界（均为 0‑based）
//         for (int j = 0, i = 0; j < m; j++) {
//             s[j] = br.readLine();

//             // 如果是目标单词，窗口内计数 +1
//             if (word.contains(s[j])) {
//                 cnt.put(s[j], cnt.getOrDefault(s[j], 0) + 1);
//             }

//             // 该目标单词首次出现 → 种类数 +1，更新当前窗口长度
//             if (cnt.getOrDefault(s[j], 0) == 1) {
//                 sum++;
//                 len = j - i + 1;
//             }

//             // 尝试收缩左边界 i
//             while (i <= j) {
//                 int ci = cnt.getOrDefault(s[i], 0);
//                 if (ci == 1) {
//                     break;                              // 只剩一份，不能删
//                 }
//                 if (ci >= 2) {
//                     cnt.put(s[i], ci - 1);              // 有多份，删掉一份
//                     i++;
//                 }
//                 if (!word.contains(s[i])) {
//                     i++;                                // 非目标单词，直接跳过
//                 }
//             }

//             // 用当前窗口长度更新答案
//             len = Math.min(len, j - i + 1);
//         }

//         // ---------- 输出 ----------
//         if (sum == 0) {                                 // 文章中没有出现任何目标单词
//             out.println(0);
//             out.println(0);
//         } else {
//             out.println(sum);
//             out.println(len);
//         }

//         out.flush();
//     }
// }

// ============================================================================
// 原代码分析 & 双指针（滑动窗口）正确实现思路
// ============================================================================
//
// 【原代码的主要 Bug】
// 原代码用 sum 记录窗口中不同目标单词数，用 len 记录最短段长度。
// 但 len 与 sum 没有正确关联：
//   - 第 89 行：每当发现新的目标单词（sum++），就以当前窗口长度覆盖 len。
//     这时的 len 对应的是「刚达到新 sum 时的窗口」，可能不是最短。
//   - 第 108 行：之后又用 Math.min(len, ...) 更新，但 len 可能残留了
//     上一个（更小的）sum 对应的值，导致最终输出错误。
//
//   反例：target = {a,b,c}, article = a, a, b, c
//     right=0, s[0]=a: sum=1, len=1
//     right=1, s[1]=a, 收缩后 left=1: sum=1, len=min(1,1)=1
//     right=2, s[2]=b: sum=2, len=j-i+1=2-1+1=2 → len=min(1,2)=1  ← 错了！
//     len=1 对应 sum=1 的最短窗口，但被用到了 sum=2 的场景。
//
// 【修复方案】
// 引入 maxDistinct（全局最大不同单词数），将 minLen 与 maxDistinct 绑定：
//   1. distinct > maxDistinct → 重置 maxDistinct 和 minLen
//   2. distinct == maxDistinct → 才用当前窗口长度尝试更新 minLen
//   这两步放在收缩左边界之后执行。
//
// 【正确算法的伪代码】
//
//   Set<String> targetSet   ← 目标单词集合
//   Map<String, Integer> freq ← 窗口内目标单词的出现次数
//   int distinct   = 0    ← 当前窗口中的不同目标单词数
//   int maxDistinct = 0   ← 全局最大不同目标单词数
//   int minLen     = 0    ← 达到 maxDistinct 的最短窗口长度
//   int left = 0
//
//   for right in [0, m):
//       word = article[right]
//
//       // --- 1. 扩展右边界 ---
//       if targetSet.contains(word):
//           cnt = freq.getOrDefault(word, 0)
//           freq.put(word, cnt + 1)
//           if cnt == 0:           // 该目标单词在窗口中首次出现
//               distinct++
//
//       // --- 2. 收缩左边界 ---
//       // 在保持 distinct 不减少的前提下，尽量右移 left
//       while left <= right:
//           leftWord = article[left]
//           if !targetSet.contains(leftWord):
//               left++                        // 非目标单词，直接跳过
//           else:
//               cnt = freq.get(leftWord)
//               if cnt > 1:
//                   freq.put(leftWord, cnt - 1)  // 有多余副本，丢弃一个
//                   left++
//               else:
//                   break                     // 只剩一份，不能再删
//
//       // --- 3. 更新答案 ---
//       // 关键：仅在 distinct >= maxDistinct 时才可能更新答案
//       curLen = right - left + 1
//       if distinct > maxDistinct:
//           maxDistinct = distinct
//           minLen = curLen                    // 重置（更大的 distinct）
//       else if distinct == maxDistinct:
//           minLen = Math.min(minLen, curLen)  // 尝试更短
//
//   // --- 输出 ---
//   print(maxDistinct)
//   print(minLen)
//
// 【样例推演】
//   target = {hot, dog, milk}, article = hot, dog, dog, milk, hot
//
//   right=0, hot:  freq[hot]=1, distinct=1. 收缩:left=0 freq[hot]=1 break.
//                distinct(1)>max(0) → maxDistinct=1, minLen=1
//   right=1, dog:  freq[dog]=1, distinct=2. 收缩:left=0 freq[hot]=1 break.
//                distinct(2)>max(1) → maxDistinct=2, minLen=2
//   right=2, dog:  freq[dog]=2, distinct=2. 收缩:left=0 freq[hot]=1 break.
//                distinct(2)==max(2) → minLen=min(2,3)=2
//   right=3, milk: freq[milk]=1, distinct=3. 收缩:left=0 freq[hot]=1 break.
//                distinct(3)>max(2) → maxDistinct=3, minLen=4
//   right=4, hot:  freq[hot]=2, distinct=3.
//                收缩:left=0 freq[hot]=2→1 left=1;
//                     left=1 freq[dog]=2→1 left=2;
//                     left=2 freq[dog]=1 break.
//                distinct(3)==max(3) → minLen=min(4, 4-2+1=3)=3
//
//   输出: 3 \n 3  ✅ 与题目样例一致
//
// 【复杂度】
//   时间：O(m)，每个单词至多被左右指针各访问一次
//   空间：O(n + 窗口内目标单词种类数)


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

//         //题目中的信息“包含最多的想要背的单词，并且在单词尽量多的情况下，是选出的文章段落尽量短”
//         //也就是说：

//         // for(int right = 0; right < m; right++){
//         //     String word = article[right];
//         //     //右边加入窗口
//         //     //快指针指向课文中的单词是否是单词表中需要背的单词，如果是的话就直接加入滑动窗口
//         //     //再判断是否是第一次出现在窗口中，如果是的话窗口中包含单词表中单词数量++
//         //     if(set.contains(word)){
//         //         cnt.put(word,
//         //                 cnt.getOrDefault(word,0)+1);
//         //         //第一次出现
//         //         if(cnt.get(word)==1){
//         //             have++;
//         //         }
//         //     }
//         //     /*
//         //      * 当前窗口满足条件
//         //      */
//         //     //滑动窗口中包含的单词
//         //     while(have == set.size()){
//         //         //当前包含目标单词数量
//         //         if(have > max){

//         //             max = have;
//         //             ans = right-left+1;

//         //         }
//         //         else if(have == max){

//         //             ans = Math.min(ans,right-left+1);

//         //         }
//         //         //移动左指针
//         //         String remove = article[left];
//         //         if(set.contains(remove)){
//         //             cnt.put(remove,cnt.get(remove)-1);
//         //             //窗口中没有该单词了
//         //             if(cnt.get(remove)==0){
//         //                 have--;
//         //             }
//         //         }
//         //         left++;
//         //     }
//         // }

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

import java.util.*;

//单词表——set（Hashset）
//课文——article(String[])
//滑动窗口中记录各个单词表中需要背的单词出现的次数——cnt(HashMap)

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //目标单词集合
        //相当于单词表，初始化需要背的单词
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(sc.next());
        }
        int m = sc.nextInt();
        //article相当于存储课文的字符串数组
        String[] article = new String[m];
        for(int i = 0; i < m; i++){
            article[i] = sc.next();
        }

        //为什么目标单词/需要背的单词要用Hashset进行存储，
        //但是课文中的单词直接使用字符串数组就可以进行存储？



        //窗口中单词出现次数
        HashMap<String,Integer> cnt = new HashMap<>();
        int left = 0;
        //当前窗口包含多少种目标单词
        //当前窗口中包含的单词表中单词的数量
        int have = 0;
        //最大包含数量
        //滑动窗口中包含的单词一直在变化，用一个max值计数这个过程中出现的包含单词表中最多单词的一种情况
        int max = 0;
        //最短长度
        //最短长度取了一个很大的初始值，方便后期对该值进行覆盖
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < m; right++){

            String word = article[right];


            //加入右端点
            if(set.contains(word)){

                cnt.put(word,
                        cnt.getOrDefault(word,0)+1);
                //// Java 7 及以前，需要 4 行
                // if (cnt.containsKey(word)) {
                //     cnt.put(word, cnt.get(word) + 1);
                // } else {
                //     cnt.put(word, 1);
                // }

                // // Java 8+，一行搞定
                // cnt.put(word, cnt.getOrDefault(word, 0) + 1);


                if(cnt.get(word)==1){
                    have++;
                }
            }



            /*
             * 收缩窗口
             *
             * 删除：
             * 1.不是目标单词
             * 2.目标单词但是数量超过1
             */
            while(left <= right){

                String lword = article[left];


                if(!set.contains(lword)){
                    left++;
                }
                else if(cnt.get(lword)>1){

                    cnt.put(lword,cnt.get(lword)-1);
                    left++;

                }
                else{
                    break;
                }

            }



            //更新答案

            if(have > max){

                max = have;
                ans = right-left+1;

            }
            else if(have == max){

                ans = Math.min(ans,right-left+1);

            }


        }
        System.out.println(max);
        System.out.println(ans);
    }
}