package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    List<String> ans;
    StringBuilder sb;

    String[] nunMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 电话号码的组合
     */
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return ans;
        }
        sb = new StringBuilder();
        backTrace(digits, 0);
        return ans;
    }

    private void backTrace(String digits, int start) {
        if (start == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String str = nunMap[digits.charAt(start) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTrace(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
