package main.Java.DP;

import java.util.Arrays;

/**
 * @author clearlove3
 * @date 2023/10/16 15:09
 */
public class LeetCode213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{200,3,140,20,10}));
    }
    public static int rob(int[] nums) {
        // 2种情况，dp拿第一个不拿最后一个，即只考虑0~n-2
        // dp2不拿第一个拿最后一个，只考虑1~n-1
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1){
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);

        if(nums.length == 2){
            return dp[1];
        }
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < nums.length-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        for (int i = 3; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+nums[i]);
        }
        dp[nums.length-1] = dp[nums.length-2];
        dp2[nums.length-1] = Math.max(dp2[nums.length-2], dp2[nums.length-3] + nums[nums.length-1]);
//        System.out.println(Arrays.toString(Arrays.stream(dp).toArray()));
//        System.out.println(Arrays.toString(Arrays.stream(dp2).toArray()));
        return Math.max(dp[nums.length-1], dp2[nums.length-1]);
    }
}
