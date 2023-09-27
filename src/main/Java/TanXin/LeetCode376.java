package main.Java.TanXin;

public class LeetCode376 {
    /**
     * 最长摆动子序列
     * 贪心算法
     */
    public int wiggleMaxLength1(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            // 获取当前差值
            curDiff = nums[i] - nums[i-1];
            // 如果是山峰则ans++，即当前值加入子序列
            // 否则不做处理，即将该值略过
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }

    /**
     * 动态规划
     */
    public int wiggleMaxLength2(int[] nums) {
        // dp[i][0]表示考虑前 i 个数，第 i 个数作为山谷的摆动子序列的最长长度
        // dp[i][1]表示考虑前 i 个数，第 i 个数作为山峰的摆动子序列的最长长度
        int[][] dp = new int[nums.length][2];
        // 初始化都是1
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            // 可以自成山峰
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]){
                    // i当山谷则长度为j当山峰的值+1，判断哪个更大
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[j] < nums[i]){
                    // i当山峰则长度为j当山谷的值+1，判断哪个更大
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}
