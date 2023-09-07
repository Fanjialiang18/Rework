package main.Java.ZiFuChuan;

/**
 * 前K个反转字符串
 *
 * @author fanjl-a
 * @date 2023/9/7 16:26
 */
public class Leetcode541 {
    public String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int front = i;
            int back = Math.min(i + k - 1, s.length() - 1);
            while (front < back) {
                char t = ss[front];
                ss[front] = ss[back];
                ss[back] = t;
                front++;
                back--;
            }
        }
        return new String(ss);
    }
}
