package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/16 17:57
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        // 四种状态:1.今天持有股票，2.今天未持有股票不是冷冻期，3.今天卖出股票，4.今天冷冻期
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
