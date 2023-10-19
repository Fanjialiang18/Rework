package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/19 13:06
 */
public class LeetCode115 {
    public int numDistinct(String s, String t) {
        // dp[i][j]表示0~j-1的t在0~i-1的s中出现的次数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (j > i) {
                    break;
                }
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j] % mod;
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
