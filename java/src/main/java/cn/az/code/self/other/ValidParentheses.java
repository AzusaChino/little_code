package cn.az.code.self.other;

import java.util.Stack;

/**
 * @author az
 * @since 08/19/20
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int pairCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (!stack.isEmpty()) {
                if (stack.peek() != '(') {

                }
                return false;
            }
        }
        return stack.isEmpty();
    }


    static class ValidParenthesesString {
        //When you met "(", you know you need one only one ")", cmin = 1 and cmax = 1.
        //When you met "(*(", you know you need one/two/three ")", cmin = 1 and cmax = 3.
        public boolean isValid(String s) {
            int cmin = 0, cmax = 0;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '(') {
                    cmax++;
                    cmin++;
                } else if (c == ')') {
                    cmax--;
                    cmin = Math.max(cmin - 1, 0);
                } else {
                    cmax++;
                    cmin = Math.max(cmin - 1, 0);
                }
                if (cmax < 0) {
                    return false;
                }
            }
            return cmin == 0;
        }
    }
}
