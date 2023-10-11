package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/11 15:08
 */
public class LeetCode416 {
    /**
     * 二维数组版本
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int bagSize = sum / 2;
        int[][] dp = new int[nums.length][bagSize + 1];
        for (int i = nums[0]; i < bagSize; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] == sum / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 一维数组版本
     */
    public boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int bagSize = sum / 2;
        int[] dp = new int[bagSize + 1];
        // 背包容量倒序，
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == sum / 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
