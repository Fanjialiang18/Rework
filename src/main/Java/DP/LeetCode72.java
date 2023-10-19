package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/19 15:34
 */
public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        // dp[i][j]表示以i-1结尾的word1和j-1结尾的word2的最短编辑距离
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 删除一个，添加一个，替换一个
                    // 删除一个=添加一个，考虑为任意一个前一个的匹配dp[i-1][j]+1或者dp[i][j-1]+1
                    // 替换一个就是考虑两个的前一个的匹配
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
