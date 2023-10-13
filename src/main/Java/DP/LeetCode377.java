package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/13 15:16
 */
public class LeetCode377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示组合的和为i的种类数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 求组合要先遍历物品，而求排列要先遍历背包
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
