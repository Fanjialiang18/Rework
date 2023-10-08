package main.Java.TanXin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length-1; i++) {
            if(right < intervals[i+1][0]){
                // 不重叠则加入之前的数组
                ans.add(new int[]{left, right});
                left = intervals[i+1][0];
                right = intervals[i+1][1];
            }else {
                // 重叠则更新右边界
                right = Math.max(right, intervals[i+1][1]);
            }
        }
        ans.add(new int[]{left, right});
        return ans.toArray(new int[ans.size()][]);
    }
}
