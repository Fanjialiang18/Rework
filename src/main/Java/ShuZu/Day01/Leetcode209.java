package main.Java.ShuZu.Day01;

public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0; //双指针
        int sum = 0; // 区间和
        int result = Integer.MAX_VALUE; // 区间长度，因为要求最小值所以初始化为最大值
        for (; right < nums.length; right++) { //循环移动右指针
            sum += nums[right];
            // 满足条件后移动左指针
            while (sum >= target) {
                // 更新结果值
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        // 若result未被修改则说明没有满足条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}