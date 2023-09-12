package main.Java.ZhanAndDuiLie;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author clearlove3
 * @date 2023/9/12 16:52
 */
public class LeetCode347 {
    /**
     * 前K个高频元素，经典题目
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 升序排列的优先级队列
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2)->pair1[1]-pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 维护K个元素即可
            if(pq.size()<k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                // 超过K就弹出队头元素
                if(entry.getValue() > pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 先出队的是频率较小的，倒着插（其实无所谓
        for (int i = k-1; i >=0 ; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
