package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {
    List<List<Integer>> ans;

    LinkedList<Integer> path;

    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backTrace(k, n, 1);
        return ans;
    }

    private void backTrace(int k, int n, int start) {
        if (sum > n) {
            return;
        }
        if (path.size() == k && sum == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < 10; i++) {
            path.add(i);
            sum += i;
            backTrace(k, n, i + 1);
            sum -= path.getLast();
            path.removeLast();
        }
    }
}
