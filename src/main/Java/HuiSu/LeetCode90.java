package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode90 {

    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 带有重复元素的子集问题
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        backTrace(nums, 0);
        return ans;
    }

    private void backTrace(int[] nums, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 这里去重条件是i>start而不是i>0
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTrace(nums, i + 1);
            path.removeLast();
        }
    }
}
