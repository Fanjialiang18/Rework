package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/18 19:31
 */
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        // dp[i][j]表示以下标i-1为结尾的字符串s
        // 和以下标j-1为结尾的字符串t，相同子序列的长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }
}
