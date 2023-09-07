package main.Java.ZiFuChuan;

/**
 * 反转字符串
 *
 * @author fanjl-a
 * @date 2023/9/7 15:52
 */
public class Leetcode344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
