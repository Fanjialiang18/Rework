package main.Java.ShuZu.Day01;

public class Leetcode977 {
    /**
     * 有序数组的平方
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        // 结果数组
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, resultIndex = nums.length-1;
        while (resultIndex>=0) {
            // 比较左右平方值，较大结果的移动下标
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[resultIndex] = nums[left] * nums[left];
                left++;
            } else {
                result[resultIndex] = nums[right] * nums[right];
                right--;
            }
            // 倒着存放结果，因为结果是由大到小的
            resultIndex --;
        }
        return result;
    }
}
