package main.Java.TanXin;

public class LeetCode53 {
    /**
     * 最大子序列和
     * 贪心
     */
    public int maxSubArray1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        // 连续和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > ans) {
                ans = sum;
            }
            // 舍弃连续和为负数的部分
            if (sum <= 0) {
                sum = 0;
            }
        }
        return ans;
    }

    /**
     * 最大子序列和
     * DP
     */
    public int maxSubArray2(int[] nums) {
        // dp[i]表示包括i的之前的最大子序列的值
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if (dp[i] > ans){
                ans = dp[i];
            }
        }
        return ans;
    }
}
