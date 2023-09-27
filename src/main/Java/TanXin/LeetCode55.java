package main.Java.TanXin;

public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            if (i + nums[i] > max) {
                max = i + nums[i];
                if (max > nums.length - 1) {
                    return true;
                }

            }
        }
        return max >= nums.length - 1;
    }
}
