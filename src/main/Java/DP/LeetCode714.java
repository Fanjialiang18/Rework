package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/16 18:16
 */
public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        // 0表示持有股票，1表示不持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return dp[prices.length-1][1];
    }
}
