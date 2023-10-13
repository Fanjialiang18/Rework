package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/13 16:18
 */
public class LeetCode279 {
    public int numSquares(int n) {
        // dp[i]表示和为i的最小数目
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1, n + 1, Integer.MAX_VALUE);
        for (int i = 1; i <= 100; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }
}
