package main.Java.ZhanAndDuiLie;

import java.util.Stack;

/**
 * @author clearlove3
 * @date 2023/9/12 15:23
 */
public class LeetCode150 {
    /**
     * 逆波兰表达式求值
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            int num1 = 0;
            int num2 = 0;
            switch (s) {
                case "+":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 + num1));
                    break;
                case "-":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 - num1));
                    break;
                case "*":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 * num1));
                    break;
                case "/":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(num2 / num1));
                    break;
                default:
                    stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
