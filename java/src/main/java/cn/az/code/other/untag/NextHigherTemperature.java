package cn.az.code.other.untag;

import java.util.Stack;

/**
 * @author azusachino
 */
public class NextHigherTemperature {

    public int[] nextHigherTemperatures(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            ret[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ret;
    }
}