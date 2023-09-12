package main.Java.ZhanAndDuiLie;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author clearlove3
 * @date 2023/9/12 14:02
 */
public class LeetCode225 {
    /**
     * 用队列实现栈
     */
    class MyStack {

        private final Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
