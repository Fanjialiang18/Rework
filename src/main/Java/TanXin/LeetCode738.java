package main.Java.TanXin;

public class LeetCode738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        // 标记从哪里开始赋值为9
        int start = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            // 如果不满足单调增了，就改变当前数，同时标记赋值为9的地方
            if (chars[i-1] > chars[i]) {
                chars[i-1]--;
                start = i;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
