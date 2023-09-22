package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode491 {

    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 递增子序列
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backTrace(nums, 0);
        return ans;
    }

    private void backTrace(int[] nums, int start) {
        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast() || used[nums[i] + 100]) {
                continue;
            }
            used[nums[i] + 100] = true;
            path.add(nums[i]);
            backTrace(nums, i + 1);
            path.removeLast();
        }
    }
}
