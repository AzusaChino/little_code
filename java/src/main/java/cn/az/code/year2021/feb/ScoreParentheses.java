package cn.az.code.year2021.feb;

import java.util.Stack;

/**
 * @author ycpang
 * @since 2021-02-24 16:06
 */
public class ScoreParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
}
