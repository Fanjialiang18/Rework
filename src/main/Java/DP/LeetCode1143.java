package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/18 16:29
 */
public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j]:长度为[0, i - 1]的字符串text1
        // 与长度为[0, j - 1]的字符串text2的最长公共子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不相等的话匹配前一位选最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
