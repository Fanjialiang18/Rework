package main.Java.TanXin;

import java.util.Arrays;

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        // 将两个数组都由低向高排序
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}
