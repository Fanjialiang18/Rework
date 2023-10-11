package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/11 16:00
 */
public class LeetCode494 {
    /**
     * 二维数组法
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int left = (sum + target) / 2;
        //dp[i][j]表示用0-i的数装满j的方法总数
        int[][] dp = new int[nums.length][left + 1];
        // 初始化第一行
        if(nums[0] <= left){
            dp[0][nums[0]] = 1;
        }
        // 初始化第一列
        // 背包容量为0，每个元素为0是都有2种选法
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= left; j++) {
                if (j >= nums[i]) {
                    // 不拿i和拿了i的方法总和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][left];
    }

    /**
     * 一维数组法
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int left = (sum + target) / 2;
        //dp[i]表示装满j的方法总数
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                // dp[j]表示不拿i，dp[j-nums[i]]表示拿了i
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[left];
    }
}
