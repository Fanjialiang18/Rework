package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/11 17:13
 */
public class LeetCode518 {
    /**
     * 二维数组版本
     */
    public int change(int amount, int[] coins) {
        // dp[i][j]表示用0-i的硬币装满j的方法数
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // i的硬币可以用k次，累加
                for (int k = 0; k * coins[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    /**
     * 一维数组版本
     */
    public int change2(int amount, int[] coins) {
        // dp[i]表示装满i的方法数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
