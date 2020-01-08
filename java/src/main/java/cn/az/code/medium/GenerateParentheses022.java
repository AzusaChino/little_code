package cn.az.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liz
 * @version 2019/11/30
 */
public class GenerateParentheses022 {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses022().generate(3));
    }

    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(List<String> res, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            res.add(str);
        }
        if (open < n) {
            helper(res, str + "(", open + 1, close, n);
        }
        if (close < open) {
            helper(res, str + ")", open, close + 1, n);
        }
    }
}
