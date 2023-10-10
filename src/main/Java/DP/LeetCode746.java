package main.Java.DP;

public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        // dp[0]和dp[1]都是0，所以不用初始化
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
