package main.Java.ShuZu.Day01;

public class Leetcode704 {
    /**
     * 二分查找，左闭右开
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > target){
                right = middle;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }
}
