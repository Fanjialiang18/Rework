package main.Java.ZiFuChuan;

/**
 * @author clearlove3
 * @date 2023/9/11 14:59
 */
public class Leetcode28 {
    /**
     * 字符串模式匹配:KMP算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty() || haystack.length() < needle.length()){
            return -1;
        }
        // 构造next数组，j为前缀末尾下标，i为后缀末尾下标
        // 前缀不包含最后一位，后缀不包含第一位，所以初始化为j=0-1,i=0+1
        int[] next = new int[needle.length()];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++){
            // 不相同则回退，next[j]就是记录着j（包括j）之前的子串的相同前后缀的长度
            // 要找 j+1的前一个元素在next数组里的值（就是next[j]）
            while(j >= 0 && needle.charAt(i) != needle.charAt(j+1)){
                j=next[j];
            }
            // 相同则都后移
            if(needle.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }

        // 进行模式匹配
        int k = -1;
        for (int i = 0; i < haystack.length(); i++) {
            // 不匹配则回退
            while (k >= 0 && haystack.charAt(i) != needle.charAt(k+1)){
                k = next[k];
            }
            // 相同则后移
            if(haystack.charAt(i) == needle.charAt(k+1)){
                k++;
            }
            // 判断是否匹配完
            if (k == needle.length()-1){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
}
