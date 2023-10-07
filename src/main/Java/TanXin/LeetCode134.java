package main.Java.TanXin;

public class LeetCode134 {
    /**
     * 加油站
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curRestSum = 0;
        int start = 0;
        int totalRestSum = 0;
        for (int i = 0; i < cost.length; i++) {
            curRestSum += (gas[i] - cost[i]);
            totalRestSum += (gas[i] - cost[i]);
            if(curRestSum < 0 ){
                curRestSum = 0;
                start = i + 1;
            }
        }
        if (totalRestSum < 0){
            return -1;
        }
        return start;
    }
}
