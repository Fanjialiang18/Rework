package main.Java.DP;

public class LeetCode70 {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        int sum = 0;
        for (int i = 3; i < n+1; i++) {
            sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return sum;
    }

    /**
     * 其实是一个完全背包问题
     * 将1，2改成能够跳m次
     * 那么1-m是物品，楼梯是背包，并且是完全背包，还是排列问题
     */
    public int climbStairs2(int n, int m) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i>=j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
