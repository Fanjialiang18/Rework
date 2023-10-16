package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/16 17:49
 */
public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        // 2k种状态，分别为第1次持有，第1次不持有~~~第k次持有，第k次不持有
        int[][] dp = new int[prices.length][2*k];
        for (int i = 0; i < 2*k; i+=2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            for (int j = 2; j < 2*k; j+=2) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]-prices[i]);
            }
            for (int j = 1; j < 2 * k; j+=2) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + prices[i]);
            }
        }
        return dp[prices.length-1][2*k-1];
    }
}
