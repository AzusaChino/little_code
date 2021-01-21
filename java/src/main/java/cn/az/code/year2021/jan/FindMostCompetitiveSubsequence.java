package cn.az.code.year2021.jan;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ycpang
 * @since 2021-01-21 20:31
 */
public class FindMostCompetitiveSubsequence {

    public static void main(String[] args) {
        FindMostCompetitiveSubsequence fmc = new FindMostCompetitiveSubsequence();
        int[] nums = {3, 5, 2, 6};
        System.out.println(Arrays.toString(fmc.mostCompetitive(nums, 2)));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()] && nums.length - i + stack.size() > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }
}
