package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode77 {
    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 组合问题
     */
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        // 频繁增删，使用链表
        path = new LinkedList<>();
        if (n < 1 || k < 1) {
            return ans;
        }
        backTrace(n, k, 1);
        return ans;
    }

    private void backTrace(int n, int k, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 剪枝操作
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTrace(n, k, i + 1);
            path.removeLast();
        }
    }
}
