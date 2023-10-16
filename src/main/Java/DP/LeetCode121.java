package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/16 16:37
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        // 贪心
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        // DP，dp[i][0]表示第i天持有股票所得最多现金，dp[i][1]表示不持有股票所得最多现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
