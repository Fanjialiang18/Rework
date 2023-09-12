package main.Java.ZhanAndDuiLie;

import java.util.Stack;

/**
 * @author clearlove3
 * @date 2023/9/12 14:54
 */
public class LeetCode1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
//        int i = 0;
//        int j = sb.length()-1;
//        while (i < j){
//            char t = sb.charAt(i);
//            sb.setCharAt(i, sb.charAt(j));
//            sb.setCharAt(j, t);
//            i++;
//            j--;
//        }
//        return sb.toString();
    }
}
