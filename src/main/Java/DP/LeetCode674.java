package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/18 15:22
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
