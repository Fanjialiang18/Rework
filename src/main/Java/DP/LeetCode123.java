package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/16 17:39
 */
public class LeetCode123 {
    public int maxProfit(int[] prices) {
        // 每天4种状态：
        // 1:第一次持有股票
        // 2:第一次不持有股票
        // 3:第二次持有股票
        // 4:第二次不持有股票
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][1] - prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2] + prices[i], dp[i-1][3]);
        }
        return dp[prices.length-1][3];
    }
}
