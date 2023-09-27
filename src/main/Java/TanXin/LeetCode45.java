package main.Java.TanXin;

public class LeetCode45 {
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        // 当前最大覆盖
        int curMaxDistance = 0;
        int count = 0;
        // 下一步的最大覆盖
        int nextMaxDistance = 0;
        for (int i = 0; i < nums.length - 1 ; i++) {
            // 更新下一步的值
            nextMaxDistance = Math.max(nextMaxDistance, nums[i] + i);
            // 如果走到了当前的最大覆盖还没到终点，说明必须多走一步
            if (i == curMaxDistance){
                curMaxDistance = nextMaxDistance;
                count++;
            }

        }
        return count;
    }
}
