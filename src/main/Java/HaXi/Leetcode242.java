package main.Java.HaXi;

import java.util.HashMap;

public class Leetcode242 {
    /**
     * 异位字符
     * 哈希表的原理
     * 全为小写字母的话数组更方便，hashMap更通用
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 解法1哈希表
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                // 因为长度相等，所以要么满足条件最后全为0，要么必有次数为负数的字符
                if (map.get(t.charAt(i)) < 0) {
                    return false;
                }
            }
        }
        return true;

        // 解法2:数组
//        if(s.length() != t.length()){
//            return false;
//        }
//        int[] used = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            used[s.charAt(i)-'a']++;
//        }
//        for (int i = 0; i < t.length(); i++) {
//            used[t.charAt(i)-'a']--;
//        }
//        for (int i : used) {
//            if(i!=0){
//                return false;
//            }
//        }
//        return true;
    }
}
