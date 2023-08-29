package main.Java.HaXi;

import java.util.HashMap;

public class Leetcode1 {
    /**
     * 两数之和
     * 保存需要的值作为key，下标作为value
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                res[0] = i;
                res[1] = map.get(nums[i]);
                break;
            }else {
                map.put(target-nums[i], i);
            }
        }
        return res;
    }
}
