package cn.az.code.self.other;

import java.util.Stack;

/**
 * @author az
 * @since 08/19/20
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses("(((()"));
    }
    public int longestValidParentheses(String s) {
        int max = Integer.MIN_VALUE;
        s += "x";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                if (stack.empty()) {
                    max = Math.max(max, i);
                } else {
                    max = Math.max(max, i - stack.peek() - 1);
                }
                stack.push(i);
            }
        }
        return stack.empty() ? s.length() : max;
    }
}
