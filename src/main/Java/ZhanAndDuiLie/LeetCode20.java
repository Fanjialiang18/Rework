package main.Java.ZhanAndDuiLie;

import java.util.Stack;

/**
 * @author clearlove3
 * @date 2023/9/12 14:29
 */
public class LeetCode20 {
    /**
     * 有效括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
