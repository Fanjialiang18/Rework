package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode131 {

    List<List<String>> ans;

    LinkedList<String> path;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backTrace(s, 0);
        return ans;
    }

    private boolean isReverse(String s){
        int i = 0;
        int j = s.length() -1 ;
        while (i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void backTrace(String s, int start){
        if (start >= s.length()){
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            // 如果切割出的串是回文串则进行下一步递归，否则直接跳过
            if(isReverse(s.substring(start, i+1))){
                path.add(s.substring(start, i+1));
                backTrace(s, i + 1);
                path.removeLast();
            }
        }
    }
}
