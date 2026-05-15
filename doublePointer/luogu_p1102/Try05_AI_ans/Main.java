package doublePointer.luogu_p1102.Try05_AI_ans;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int c = Integer.parseInt(first[1]);

        String[] nums = br.readLine().split(" ");

        // ✅ 改进1：使用 HashMap 统计每个数的出现次数（O(n)）
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(nums[i]);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        long ans = 0; // ✅ 改进2：用 long 防止答案溢出

        // ✅ 改进3：遍历每个“B”，找 A = B + C
        for (int b : map.keySet()) {

            int a = b + c;

            // 如果存在 A
            if (map.containsKey(a)) {

                // ✅ 核心公式：组合数 = 出现次数相乘
                ans += (long) map.get(b) * map.get(a);
            }
        }

        System.out.println(ans);
    }
}
