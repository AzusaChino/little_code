package cn.az.code.other.untag;

import java.util.Stack;

/**
 * @author azusachino
 */
public class NextGreaterElementsCircle {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            ret[i % n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return ret;
    }
}