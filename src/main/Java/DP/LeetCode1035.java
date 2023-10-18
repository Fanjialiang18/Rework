package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/18 17:23
 */
public class LeetCode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 长度为[0, i - 1]的数组1
        // 与长度为[0, j - 1]的数组2的最长公共子序列
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
