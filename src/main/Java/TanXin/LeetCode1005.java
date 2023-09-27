package main.Java.TanXin;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(newNums, Comparator.comparingInt(Math::abs));
        // 从绝对值大到小，翻转负数
        for (int i = newNums.length - 1; i >= 0; i--) {
            if (newNums[i] < 0 && k > 0) {
                newNums[i] *= -1;
                k--;
            }
        }
        // 如果负数都改完了还没结束，那么就改绝对值最小的正数
        if (k % 2 == 1) {
            newNums[0] *= -1;
        }
        int sum = 0;
        for (Integer i : newNums) {
            sum += i;
        }
        return sum;
    }
}
