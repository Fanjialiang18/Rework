package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/11 16:46
 */
public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        // 最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        // 实际为1维背包问题，m和n是两个容量维度
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int zeroNums = 0;
            int oneNums = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '0'){
                    zeroNums++;
                }else {
                    oneNums++;
                }
            }
            for (int i = m; i >= zeroNums; i--) {
                for (int j = n; j >= oneNums ; j--) {
                    // 拿了该字符串，遍历取最大值
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNums][j-oneNums]+1);
                }
            }
        }
        return dp[m][n];
    }
}
