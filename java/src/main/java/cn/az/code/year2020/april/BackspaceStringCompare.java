package cn.az.code.year2020.april;

import java.util.Stack;

/**
 * @author az
 * @since 10/14/20
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }

    public boolean backspaceCompare_(String S, String T) {
        Stack<String> s1 = new Stack<>(), s2 = new Stack<>();
        for (String c : S.split("")) {
            if ("#".equals(c)) {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }
        for (String c : T.split("")) {
            if ("#".equals(c)) {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }

        return String.join("", s1).equals(String.join("", s2));
    }

}
