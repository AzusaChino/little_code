package cn.az.code.hard;

import java.util.Stack;

/**
 * The type Longest valid parentheses 032.
 * @author azusachino
 */
public class LongestValidParentheses_032 {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses_032().longestValidParentheses("(())"));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    left = j;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j - left);
                    } else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }

}
