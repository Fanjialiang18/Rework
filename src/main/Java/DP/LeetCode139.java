package main.Java.DP;

import java.util.HashSet;
import java.util.List;

/**
 * @author clearlove3
 * @date 2023/10/13 17:06
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        // 外层背包内层物品
        // 物品就是s串的前j个字符
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
