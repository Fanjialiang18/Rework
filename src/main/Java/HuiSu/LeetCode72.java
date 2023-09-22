package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode72 {

    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 子集问题
     */
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        backTrace(nums, 0);
        return ans;
    }

    private void backTrace(int[] nums, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums, i + 1);
            path.removeLast();
        }
    }
}
