package cn.az.code.other.stack;

import java.util.Stack;

/**
 * @author az
 * @date 5/14/2020
 */
public class NextWarmerTemperature {

    public int[] next(int[] t) {
        int len = t.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.pop() - 1);
            stack.push(i);
        }
        return res;
    }
}
