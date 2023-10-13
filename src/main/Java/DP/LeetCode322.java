package main.Java.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/13 16:05
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示总和为i的最少硬币数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        // 要求最小的话，初始化为最大值
        Arrays.fill(dp,1,amount+1, Integer.MAX_VALUE);
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 防止越界
                if(dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
