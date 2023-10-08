package main.Java.TanXin;

import java.util.ArrayList;
import java.util.List;

public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[27];
        // 更新字符的最右边界
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 更新之前的最远边界
            right = Math.max(right, index[s.charAt(i)-'a']);
            // 如果当前位置为之前的最远边界，则进行切割
            if(i == right){
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }
}
