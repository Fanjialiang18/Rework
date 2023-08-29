package main.Java.HaXi;

import java.util.HashMap;

public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 解法1：哈希表
//        HashMap<Character, Integer> map = new HashMap<>();
//        // 初始化map
//        for (int i = 0; i < magazine.length(); i++) {
//            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
//        }
//        // 遍历ransomNote，逐个相减
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//            if (!map.containsKey(c)) {
//                return false;
//            } else {
//                Integer count = map.get(c);
//                if (count < 1) {
//                    return false;
//                }
//                map.put(c, map.get(c) - 1);
//            }
//        }
//        return true;
        // 解法2：数组
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            chars[ransomNote.charAt(i)-'a']--;
            if (chars[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
}
