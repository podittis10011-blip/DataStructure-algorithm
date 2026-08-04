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
public class Main {

    public static void main(String[] args) throws IOException {
        // ---------- 快速输入 ----------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // ---------- 读入单词表 ----------
        int n = Integer.parseInt(br.readLine());
        Set<String> word = new HashSet<>();          // 对应 C++ map<string,bool>
        for (int k = 0; k < n; k++) {
            word.add(br.readLine());
        }

        // ---------- 读入文章 ----------
        int m = Integer.parseInt(br.readLine());
        String[] s = new String[m];                   // 对应 C++ s[100005]

        Map<String, Integer> cnt = new HashMap<>();   // 对应 C++ map<string,int>
        int sum = 0;                                   // 出现过的目标单词种类数
        int len = Integer.MAX_VALUE;                   // 最短连续段长度

        // i 是窗口左边界，j 是窗口右边界（均为 0‑based）
        for (int j = 0, i = 0; j < m; j++) {
            s[j] = br.readLine();

            // 如果是目标单词，窗口内计数 +1
            if (word.contains(s[j])) {
                cnt.put(s[j], cnt.getOrDefault(s[j], 0) + 1);
            }

            // 该目标单词首次出现 → 种类数 +1，更新当前窗口长度
            if (cnt.getOrDefault(s[j], 0) == 1) {
                sum++;
                len = j - i + 1;
            }

            // 尝试收缩左边界 i
            while (i <= j) {
                int ci = cnt.getOrDefault(s[i], 0);
                if (ci == 1) {
                    break;                              // 只剩一份，不能删
                }
                if (ci >= 2) {
                    cnt.put(s[i], ci - 1);              // 有多份，删掉一份
                    i++;
                }
                if (!word.contains(s[i])) {
                    i++;                                // 非目标单词，直接跳过
                }
            }

            // 用当前窗口长度更新答案
            len = Math.min(len, j - i + 1);
        }

        // ---------- 输出 ----------
        if (sum == 0) {                                 // 文章中没有出现任何目标单词
            out.println(0);
            out.println(0);
        } else {
            out.println(sum);
            out.println(len);
        }

        out.flush();
    }
}
