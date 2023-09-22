package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode39 {

    List<List<Integer>> ans;

    int sum;

    LinkedList<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        // 排序方便剪枝，不剪枝的话可以不排序）
        Arrays.sort(candidates);
        backTrace(candidates, 0, target);
        return ans;
    }

    private void backTrace(int[] candidates, int start, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTrace(candidates, i, target);
            sum -= path.getLast();
            path.removeLast();
        }
    }
}
