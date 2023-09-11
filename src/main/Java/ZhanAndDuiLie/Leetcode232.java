package main.Java.ZhanAndDuiLie;

import java.util.Stack;

/**
 * @author fanjl-a
 * @date 2023/9/11 17:57
 */
public class Leetcode232 {
    /**
     * 用栈模拟队列
     */
    class MyQueue {
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            if (stackOut.isEmpty()){
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }

        public int peek() {
            if (stackOut.isEmpty()){
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackOut.empty() && stackIn.empty();
        }
    }
}
