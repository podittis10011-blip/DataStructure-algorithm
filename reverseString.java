import java.util.*;
import java.io.*;

public class reverseString {
    static String str;
    static char[] charArray;
    static char tempChar;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next();
        // for(int i = 0; i < str.length();i++){
        //     char element = str.charAt(0);
        // }

        charArray = str.toCharArray();

        int left = 0;int right = str.length() - 1;

        //等于，说明两个指针已经指向了同一个位置，“成功交汇”，就跳出该循环
        while(left < right){
            tempChar = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tempChar;  
            left++;
            right--;
        }

        for(int i = 0; i <= str.length() - 1;i++){
            System.out.print(charArray[i]);
        }
    }
}

/*
 * ============================================================
 *  算法竞赛中 String → 数组 的常用方式
 * ============================================================

// ==================== 方式1：toCharArray() — 最常用 ====================
// 将字符串转为 char[]，可直接修改每个字符，非常适合双指针、反转等操作

    String s = "hello";
    char[] arr = s.toCharArray();   // arr = ['h','e','l','l','o']

    // 好处：可以直接修改
    arr[0] = 'H';                   // 数组变了，原字符串不变
    // 需要新字符串时再转回去：
    String result = new String(arr);  // "Hello"
    String result2 = String.valueOf(arr); // 效果相同

    // 典型场景：反转字符串
    int l = 0, r = arr.length - 1;
    while (l < r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
        l++; r--;
    }
    return new String(arr);

// ==================== 方式2：split() — 按分隔符切 ====================
// 将字符串按某字符拆成 String[]，适合处理以空格/逗号分隔的数据

    String s = "hello world java";
    String[] words = s.split(" ");  // ["hello", "world", "java"]

    // 按正则切分（split 参数是正则，特殊符号要转义）
    String[] parts = "a,b,c".split(",");        // ["a","b","c"]
    String[] parts2 = "a.b.c".split("\\.");     // 点号是正则特殊符号，要 \\. 转义

    // 限制切割份数
    String[] parts3 = "a:b:c:d".split(":", 2);  // ["a", "b:c:d"]  只切2份

// ==================== 方式3：charAt() 直接访问 — 不需要数组 ====================
// 如果不需要修改字符，直接 charAt 就可以，省去转换开销

    String s = "hello";
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);       // 只读访问，不需要转数组
    }

// ==================== 方式4：toCharArray vs charAt ？ ====================
//
//   toCharArray()：        O(n) 时间 + O(n) 空间   → 要修改、要索引时用
//   charAt(i)：            O(1) 每次    + O(1) 空间  → 只要读、顺序遍历时用
//
//   算法竞赛建议：需要修改字符内容（如反转、替换）→ 无脑 toCharArray()
//              不需要修改（如统计频率、计数）       → charAt() 就够了

// ==================== 方式5：竞技技巧：直接当字符数组遍历 ====================
// 增强 for 遍历 char[]，简洁高效

    for (char c : s.toCharArray()) {
        // 处理每个字符 c
    }

// ==================== 实战示例 ====================

// 例1：判断回文串
class Palindrome {
    boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] != arr[r]) return false;
            l++; r--;
        }
        return true;
    }
}

// 例2：统计每个字母出现次数（字母异位词）
class CharCount {
    int[] count = new int[26];
    void countChars(String s) {
        for (char c : s.toCharArray()) {
            count[c - 'a']++;   // 直接用索引，不需要 HashMap
        }
    }
}

// 例3：按空格拆分英文句子
class SplitWords {
    void printWords(String sentence) {
        String[] words = sentence.split(" ");
        for (String w : words) {
            System.out.println(w);
        }
    }
}

// ==================== 快速对比 ====================
//
// 需求                          |   用这个
// ──────────────────────────────┼────────────────────
// 双指针反转、原地修改           |   s.toCharArray()
// 按分隔符拆分                   |   s.split("分隔符")
// 只读遍历、计数统计             |   s.charAt(i) 或增强 for
// 直接取某个位置字符             |   s.charAt(index)
// 需要子串（不需要数组）          |   s.substring(begin, end)


// ============================================================
//  三个方法的详细讲解
// ============================================================

// ==================== 1. toCharArray() ====================
//
// 方法签名：
//     public char[] toCharArray()
//
// 原理：
//     String 内部是用一个 private final byte[]（或 char[]）存储的，
//     toCharArray() 会 new 一个全新的 char[]，把原字符串的每个字符
//     逐个复制过去，然后返回。正因为是新数组，修改它不会影响原字符串。
//
//     内部源码简化版（Java 8）：
//     public char[] toCharArray() {
//         char[] result = new char[length()];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = charAt(i);
//         }
//         return result;
//     }
//
// 时间复杂度：O(n) — 每个字符复制一次
// 空间复杂度：O(n) — 额外开了个等长数组
//
// 为什么算法竞赛中最常用？
//     1. 数组可以随机访问 arr[i]，速度比每次 charAt(i) 查方法快（虽然差别很小）
//     2. 可以原地修改 arr[i] = 'x'，做双指针、反转、替换等操作
//     3. 改完后 new String(arr) 就能得到修改后的字符串
//
// 示例：
//     String s = "abc";
//     char[] arr = s.toCharArray();   // arr = {'a', 'b', 'c'}
//
//     // 修改数组不影响原字符串
//     arr[0] = 'z';                   // arr = {'z', 'b', 'c'}, s 仍是 "abc"
//
//     // 数组转回字符串
//     String result = new String(arr); // result = "zbc"

// ==================== 2. charAt(int index) ====================
//
// 方法签名：
//     public char charAt(int index)
//
// 原理：
//     String 内部维护一个 byte[]/char[] value 和几个偏移量，
//     charAt(i) 直接 return value[偏移量 + i]，一次数组索引访问，O(1)。
//
//     内部源码简化版：
//     public char charAt(int index) {
//         if (index < 0 || index >= length())
//             throw new StringIndexOutOfBoundsException(index);
//         return value[index];    // 直接取，不复制任何东西
//     }
//
// 时间复杂度：O(1) 每次
// 空间复杂度：O(1) — 不额外分配内存
//
// 和 toCharArray() 的区别：
//     toCharArray() 是一次性付费 O(n) 时间 + O(n) 空间，换来随意乱序访问。
//     charAt()      是每次只花 O(1)，零额外空间，但只能读不能写。
//
//     → 如果你要遍历每个字符做统计（字母计数、判断字符类型），charAt 更省空间。
//     → 如果你要双指针反转、排序、打乱顺序，那必须 toCharArray()。
//
// 示例：
//     String s = "hello";
//     char c0 = s.charAt(0);  // 'h'
//     char c1 = s.charAt(1);  // 'e'
//     // s.charAt(5);         // 抛异常！StringIndexOutOfBoundsException

// ==================== 3. split(String regex) ====================
//
// 方法签名：
//     public String[] split(String regex)
//     public String[] split(String regex, int limit)  ← 带限制份数
//
// 原理：
//     参数是一个正则表达式（regex），String 内部用 Pattern.compile 解析，
//     找到所有匹配分隔符的位置，然后把每段截出来放进 String[]。
//
//     重点：参数是正则表达式，不是普通字符串！
//     因为正则里 . | * + ? ( ) [ ] { } ^ $ \ 这些是特殊符号，
//     如果分隔符恰好是它们，需要用 \\ 转义。
//
//     内部原理简化版：
//     - 从头扫描字符串
//     - 每遇到一个匹配的 regex 就切开
//     - 两段之间的部分放进结果数组
//     - 尾部的空字符串默认会被丢弃（split("o") on "boo" → ["b","",""] 尾部空串丢弃 → ["b"]）
//
// 时间复杂度：O(n) — 扫描一遍
// 空间复杂度：O(n) — 创建 String[] + 若干个 substring（Java 7+ 会复制子串）
//
// 常见用法：
//     "a b c".split(" ")      → ["a", "b", "c"]    空格分隔
//     "a,b,c".split(",")      → ["a", "b", "c"]    逗号分隔
//     "a.b.c".split("\\.")    → ["a", "b", "c"]    点号要转义！  \. 在 Java 字符串里写成 "\\."
//     "a|b|c".split("\\|")    → ["a", "b", "c"]    竖线要转义！
//     "abc".split("")         → ["a", "b", "c"]    空串分隔 = 每个字符拆开
//
//     带 limit 参数：
//     "a:b:c:d".split(":", 2) → ["a", "b:c:d"]    只切 1 刀，分 2 份
//     "a:b:c:d".split(":", 3) → ["a", "b", "c:d"]  只切 2 刀，分 3 份
//
// 常见坑：
//     1. 忘转义：split(".") 匹配的是正则 "." = 任意字符，结果返回空数组！
//        正确：split("\\.")
//     2. 尾部空串被吞：
//        "a,,b,".split(",")  → ["a", "", "b"]  ← 尾部空串被丢弃了
//        如果想保留：split(",", -1) → ["a", "", "b", ""]
//
// 示例：
//     String sentence = "hello world java";
//     String[] words = sentence.split(" ");
//     for (String w : words) {
//         System.out.println(w);   // hello → world → java
//     }

// ==================== 三者对比一览图 ====================
//
//               toCharArray()        charAt(i)            split(regex)
// ─────────────┼────────────────────────────────────────────────────────
//  返回类型     |  char[]              char                 String[]
//  时间复杂度   |  O(n) 一次性         O(1) 每次            O(n)
//  空间复杂度   |  O(n)                O(1)                 O(n)
//  是否可修改   |  可修改 arr[i]=?     只读                 每个元素是 String
//  参数         |  无                  索引 int             正则表达式 String
//  越界行为     |  ArrayIndexOutOf     StringIndexOutOf     不存在越界（参数问题）
//  适用场景     |  双指针/反转/替换    遍历统计/只读访问      按分隔符解析输入


// ╔══════════════════════════════════════════════════════════════════╗
// ║                    源码级深度剖析                                ║
// ╚══════════════════════════════════════════════════════════════════╝

// 前置知识：JDK 9 的 Compact Strings（JEP 254）
// ─────────────────────────────────────────────────────
// JDK 8 及之前，String 内部用 char[] 存字符，每个 char 固定占 2 字节。
// 但大多数程序中字符串都是拉丁字母（a~z, 0~9），只需要 1 字节就够了，
// 用 char 就浪费了一半内存。
//
// JDK 9 开始引入 Compact Strings 优化：
//   - byte[] value   ← 不再用 char[]，改用 byte[]
//   - byte coder     ← 标记编码方式：LATIN1(=0,1字节/字符) 或 UTF16(=1,2字节/字符)
//
// 这样纯英文串直接省一半内存，只有真正需要中文/emoji 时才用 2 字节。
// 下面所有源码都会标注 JDK 8 和 JDK 9+ 两个版本。

// ================================================================
//  1. toCharArray() 源码剖析
// ================================================================

// ─── JDK 8 实现（位于 java.lang.String）───
//
// public char[] toCharArray() {
//     // 不能因为 String 共享了 value 数组就直接 return value;
//     // 那样外部就能改你的内部状态了！！
//     char result[] = new char[value.length];
//     System.arraycopy(value, 0, result, 0, value.length);
//     return result;
// }
//
// 逐行解读：
//   ① new char[value.length]     → 分配一个全新的数组（堆上开辟新空间）
//   ② System.arraycopy(...)      → 底层是 native 方法，用 memcpy 直接复制内存块
//                                   比 for 循环快一个数量级
//   ③ return result              → 返回的是副本，外部怎么改都不影响原字符串
//
//   设计要点：防御性复制（defensive copy）
//   String 是不可变类，绝对不能暴露内部引用。
//   哪怕 value 本身已经是 private final char[]，
//   如果直接 return value，调用者拿到引用后就能修改你的内部数据：
//       char[] stolen = str.toCharArray();  // 假如返回了内部 value
//       stolen[0] = 'X';                    // str 的内容被篡改了！！
//   所以必须复制一份。

// ─── JDK 9+ 实现（位于 java.lang.String）───
//
// public char[] toCharArray() {
//     return isLatin1() ? StringLatin1.toChars(value)
//                       : StringUTF16.toChars(value);
// }
//
//   isLatin1() 就是检查 coder 字段是否为 LATIN1（值为 0）
//
// StringLatin1.toChars(byte[] value):
//     char[] result = new char[value.length];
//     for (int i = 0; i < value.length; i++) {
//         result[i] = (char)(value[i] & 0xff);  // byte 无符号扩展 → char
//     }
//     return result;
//
// StringUTF16.toChars(byte[] value):
//     char[] result = new char[value.length >> 1];       // value.length / 2
//     for (int i = 0; i < result.length; i++) {
//         result[i] = getChar(value, i);                 // 每 2 个 byte 拼 1 个 char
//     }
//     return result;
//
//   关键信息：
//   ① LATIN1 情况：value.length 就是字符数，逐字节转 char（简单 & 0xff）
//   ② UTF16 情况：value.length 是 2×字符数，每两字节拼成一个 char
//   ③ 两种分支都是创建新数组 + 复制，保证不泄露内部引用

// ─── 小结 toCharArray() ───
//   核心就是一条原则：复制一份，返回副本。
//   代价是 O(n) 时间 + O(n) 空间，换来安全性。
//   算法竞赛中 n 通常不过 10^5，这开销完全可以接受。


// ================================================================
//  2. charAt(int index) 源码剖析
// ================================================================

// ─── JDK 8 实现（位于 java.lang.String）───
//
// public char charAt(int index) {
//     if ((index < 0) || (index >= value.length)) {
//         throw new StringIndexOutOfBoundsException(index);
//     }
//     return value[index];
// }
//
//   就这么简单！三步：
//     ① 边界检查：index 在 [0, length-1] 范围内
//     ② 如果越界，抛 StringIndexOutOfBoundsException
//     ③ 直接 return value[index]（内部 char[] 的随机访问）
//
//   为什么是 O(1)？
//     数组随机访问 → 一次内存地址计算 → value 基地址 + index × 2字节
//     CPU 层面就是一条寻址指令，常数时间。

// ─── JDK 9+ 实现（位于 java.lang.String）───
//
// public char charAt(int index) {
//     if (isLatin1()) {
//         return StringLatin1.charAt(value, index);
//     } else {
//         return StringUTF16.charAt(value, index);
//     }
// }
//
// StringLatin1.charAt(byte[] value, int index):
//     return (char)(value[index] & 0xff);    // byte → char 无符号扩展
//
// StringUTF16.charAt(byte[] value, int index):
//     // 简单来说就是 value[index*2] << 8 | value[index*2+1]
//     return getChar(value, index);
//
//   本质没变，还是 O(1) 数组访问。只是多了个分支判断和
//   byte→char 的转换，开销微小到可以忽略。

// ─── charAt 和 toCharArray 设计哲学对比 ───
//
//   charAt(i):     不复制 → 不泄露 → 因为只返回一个基本类型 char
//                  基本类型是值传递，调用者拿到的是副本，无法影响 String 内部
//
//   toCharArray(): 必须复制 → 因为返回的是引用类型 char[]
//                  引用类型如果不复制，调用者就拿到了内部数组的"钥匙"
//
//   这是 Java 不可变类的经典设计模式：返回值类型 → 防御性复制，基本类型 → 直接返回。


// ================================================================
//  3. split(String regex) 源码剖析
// ================================================================

// split 是最复杂的，分两层来分析。

// ─── 第一层：String.split() 本身 ───
//
// public String[] split(String regex) {
//     return split(regex, 0);            // 调用的是双参数版本，limit=0
// }
//
// public String[] split(String regex, int limit) {
//     //  快速路径1: 单字符分隔符（非正则特殊符号 + 不是 ^.$|()[]{}*+?\ 这些）
//     //            直接用 indexOf 定位 + substring 切割，跳过正则引擎
//     //  快速路径2: 单字符正则分隔符（如 "\." → 点号，已转义完就是单字符）
//     //            也是走 indexOf + substring，快
//     //  快速路径3: 其实是两个字符，第一个是 \ 第二个是正则特殊符号 → 同上
//     //
//     //  如果以上都不满足 → 交给正则引擎
//     return Pattern.compile(regex).split(this, limit);
// }
//
// 关键发现：
//   大部分常用场景 split(",")、split(" ")、split("\\.") 走的是快速路径！
//   只有复杂正则如 split("\\s+")、split("[.,;]") 才真的启动正则引擎。
//   所以很多人以为 split 很慢——其实简单场景巨快。

// ─── 第二层：Pattern.split(CharSequence input, int limit) ───
//
// public String[] split(CharSequence input, int limit) {
//     int index = 0;                    // 当前切到哪个位置
//     boolean matchLimited = limit > 0; // limit>0 才限制切割次数
//     ArrayList<String> matchList = new ArrayList<>();  // 存放切好的结果
//     Matcher m = matcher(input);       // 用这个 Pattern 创建 Matcher
//
//     // 不断在输入串上找下一个匹配位置
//     while (m.find()) {                // ← 此处启动正则匹配，找到下一个分隔符位置
//         if (!matchLimited || matchList.size() < limit - 1) {
//             // 把 [上次切完位置, 本次匹配起始位置) 之间的子串加入结果
//             String match = input.subSequence(index, m.start()).toString();
//             matchList.add(match);
//             index = m.end();          // 游标移到匹配结束位置
//         } else {
//             // 已经切了 limit-2 份，这是最后一份（含剩余全部）
//             break;
//         }
//     }
//
//     // 循环结束后，如果还没切满且还有剩余 → 剩余部分作为最后一份
//     if (index == 0)   // 完全没找到分隔符 → 返回 [原字符串]
//         return new String[] {input.toString()};
//
//     if (!matchLimited || matchList.size() < limit)
//         matchList.add(input.subSequence(index, input.length()).toString());
//
//     // 关键：tail 裁切！limit=0 时，尾部的空字符串会被丢弃
//     int resultSize = matchList.size();
//     if (limit == 0)
//         while (resultSize > 0 && matchList.get(resultSize - 1).isEmpty())
//             resultSize--;
//
//     return matchList.subList(0, resultSize).toArray(new String[resultSize]);
// }
//
//  逐步模拟：
//     "a,,b,".split(",")    limit=0
//
//     m.find() #1 → 找到位置 1-1（第一个逗号）
//       切出 "a" → matchList = ["a"]
//     m.find() #2 → 找到位置 2-2（第二个逗号，紧挨着）
//       切出 ""  → matchList = ["a", ""]
//     m.find() #3 → 找到位置 4-4（第三个逗号）
//       切出 "b" → matchList = ["a", "", "b"]
//     m.find() #4 → 位置 5 后面没有逗号了 → 循环结束
//     剩余部分 "" → matchList = ["a", "", "b", ""]（limit=0，但暂不裁）
//
//     limit==0 → 尾部裁切：
//       resultSize=4, matchList[3]="" → resultSize-- → 3
//       matchList[2]="b" → 停止
//     最终返回 ["a", "", "b"]      ← 注意尾部空串被吃了！
//
//   split(",", -1) 就是不裁切 → ["a", "", "b", ""]

// ─── split 的性能启示 ───
//
//   1. 简单单字符分隔符（空格、逗号等）→ 触发快速路径，极快
//   2. 复杂正则 → 触发 Pattern.split，每次 find() 都有正则匹配开销
//   3. 如果在一个大循环里反复 split 同一个模式 → 提前 compile Pattern：
//      Pattern p = Pattern.compile(",");
//      for (...) { p.split(line); }  // 复用 Pattern，避免重复编译正则

// ================================================================
//  三者的底层依赖关系
// ================================================================
//
//   都离不开 String 的核心：内部字符存储
//
//   JDK 8:
//     String 内部:  private final char value[];
//     toCharArray() → 复制 value[]  →  System.arraycopy（native memcpy）
//     charAt()      → value[index]  →  单次数组随机访问
//     split()       → 最终靠 charAt/subSequence 读字符，Pattern 匹配分隔符
//
//   JDK 9+:
//     String 内部:  private final byte[] value;    +   private final byte coder;
//     toCharArray() → 读 value+coder → byte[]→char[] 逐元素转换
//     charAt()      → 读 value+coder → byte→char    单个转换
//     split()       → 同上，最底层仍是读内部 byte[] value
//
//   一句话总结：
//   String 的 value 数组是"永不对外暴露的内部数据"，
//   toCharArray 是"花钱买安全"（复制一份给你），
//   charAt 是"给你看但别碰"（读完就走），
//   split 是"按规则切好再给你"（底层也是读 + 正则匹配）。
//
 */
