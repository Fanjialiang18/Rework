package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/18 14:43
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 大于nums[j]说明可以续上
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
