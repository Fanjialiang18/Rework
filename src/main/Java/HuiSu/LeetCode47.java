package main.Java.HuiSu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47 {

    List<List<Integer>> ans;

    LinkedList<Integer> path;

    /**
     * 包含重复数字的全排列问题
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        path = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(nums, used);
        return ans;
    }

    private void backTrace(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 本层循环中，used为false说明在该层用过了
            // used为true说明是递归到下一层调用过了
            if ((i > 0 && nums[i] == nums[i - 1]) && used[i-1] == false) {
                continue;
            }
            if(used[i] == false){
                path.add(nums[i]);
                used[i] = true;
                backTrace(nums, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
