package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/16 17:32
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        // dp[i][0]表示第i天持有股票的最高利润
        // dp[i][1]表示第i天不持有股票的最高利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
