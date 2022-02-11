package cn.az.code.year2021.feb;

import java.util.Stack;

/**
 * 946
 *
 * @author ycpang
 * @since 2021-02-26 16:26
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        ValidateStackSequences vs = new ValidateStackSequences();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(vs.validateStackSequences(arr1, arr2));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0, len = pushed.length;
        while (i < len) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
                continue;
            }
            if (!s.empty() && s.peek() == popped[j]) {
                s.pop();
                j++;
                continue;
            }
            s.push(pushed[i++]);
        }
        while (!s.empty()) {
            if (s.pop() != popped[j++]) {
                return false;
            }
        }
        return true;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i;
                ++j;
            }
        }
        return i == 0;
    }
}
