package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/19 14:48
 */
public class LeetCode583 {
    public int minDistance(String word1, String word2) {
        // dp[i][j]表示以i-1结尾的word1和以j-1结尾的word2的最长公共子序列的长度
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()]*2;
    }

    public int minDistance2(String word1, String word2) {
        // dp[i][j]表示以i-1结尾的word1和以j-1结尾的word2的要达成相同时需要删除的步数
        int[][] dp = new int[word1.length()+1][word2.length()+1];
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
//                    dp[i][j] = Math.min(dp[i-1][j] + 1,Math.max(dp[i][j-1] + 1, dp[i-1][j-1] + 2));
                    // 因为dp[i-1][j-1]+2=dp[i][j-1]，所以可以简化
                    dp[i][j] = Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
