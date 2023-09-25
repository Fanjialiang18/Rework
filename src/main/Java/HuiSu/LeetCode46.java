package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {

    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 全排列问题
     */
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        boolean[] used = new boolean[21];
        backTrace(nums, used);
        return ans;
    }

    private void backTrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i] + 10]) {
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 10] = true;
            backTrace(nums, used);
            path.removeLast();
            used[nums[i] + 10] = false;
        }
    }
}
