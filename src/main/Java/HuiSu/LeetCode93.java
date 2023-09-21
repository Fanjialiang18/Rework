package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    List<String> ans;

    int numOfPoint = 0;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        backTrace(s, 0);
        return ans;
    }

    // 判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果大于255了不合法
                return false;
            }
        }
        return true;
    }

    private void backTrace(String s, int start){
        if (numOfPoint == 3){
            if(isValid(s, start, s.length() -1 )){
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(isValid(s, start, i)){
                s = s.substring(0, i+1)+'.'+s.substring(i+1);
                numOfPoint++;
                // 插入了.所以要+2而不是+1
                backTrace(s, i + 2);
                numOfPoint--;
                // 删除.
                s = s.substring(0, i+1) + s.substring(i+2);
            }
        }
    }
}
