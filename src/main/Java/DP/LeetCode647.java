package main.Java.DP;

/**
 * @author clearlove3
 * @date 2023/10/19 16:01
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        // dp[i][j]表示[i,j]的串是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        // 遍历顺序需要是从下到上，从左到右，因为dp[i+1][j-1]在dp[i][j]的左下角
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        // 一个或者两个字符就是回文串
                        ans++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            // 里面的也是回文串才是回文串
                            ans++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
