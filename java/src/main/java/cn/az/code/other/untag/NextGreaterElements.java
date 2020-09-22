package cn.az.code.other.untag;

import java.util.Stack;

/**
 * @author azusachino
 */
public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ret[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }
}