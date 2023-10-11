package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/11 15:42
 */
public class LeetCode1049 {

    /**
     * 二维数组版本
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;
        int[][] dp = new int[stones.length][bagSize + 1];
        for (int i = stones[0]; i <= bagSize; i++) {
            dp[0][i] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (stones[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[stones.length - 1][bagSize];
    }

    /**
     * 一维数组版本
     */
    public int lastStoneWeightII2(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = bagSize; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[bagSize];
    }
}
