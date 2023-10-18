package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/18 19:09
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        // dp[i]表示以nums[i]结尾的最大连续子序列和
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
