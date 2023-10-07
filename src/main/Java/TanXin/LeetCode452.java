package main.Java.TanXin;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        int ans = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < points.length; i++) {
            // 气球i和气球i-1不挨着
            if (points[i][0] > points[i - 1][1]) {
                ans++;
            } else {
                // 气球i和气球i-1挨着则更新重叠气球最小右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return ans;
    }
}
