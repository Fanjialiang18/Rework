package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/19 17:12
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        // dp[i][j]表示[i, j]最长回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        // 从下往上，从左往右
        for (int i = s.length()-1; i >= 0 ; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
