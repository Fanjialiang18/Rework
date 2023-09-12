package main.Java.ZhanAndDuiLie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author clearlove3
 * @date 2023/9/12 16:15
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        int index = 0;
        // 首先加入前K个数
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast()<nums[i]){
                queue.removeLast();
            }
            queue.add(nums[i]);
        }
        res[index++] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            // 移除前一个元素，若最大值是要移除的元素，才出队，否则不用出队
            if(!queue.isEmpty() && queue.peek() == nums[i-k]){
                queue.poll();
            }
            // 添加新的元素
            while (!queue.isEmpty() && queue.getLast()<nums[i]){
                queue.removeLast();
            }
            queue.add(nums[i]);
            res[index++] = queue.peek();
        }
        return res;
    }
}
