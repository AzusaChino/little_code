package cn.az.code.year2020.may;

import java.util.Stack;

/**
 * @author az
 * @date 5/14/2020
 */
public class RemoveDigits {

    public String removeKdigits(String num, int k) {

        int len = num.length();
        if (k == 0) {
            return num;
        }
        if (k == len) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < len) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(index)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(index++));
        }
        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder smallest = new StringBuilder();
        while (!stack.isEmpty()) {
            smallest.insert(0, stack.pop());
        }

        // delete leading zeros
        while (smallest.length() > 1 && smallest.charAt(0) == '0') {
            smallest = new StringBuilder(smallest.substring(1));
        }

        return smallest.toString();

    }

}
