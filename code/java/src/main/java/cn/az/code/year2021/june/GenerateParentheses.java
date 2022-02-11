package cn.az.code.year2021.june;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 2021-06-16
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, n);
        return res;
    }

    // result, current state, index, end 
    private void helper(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max << 1) {
            list.add(str);
            return;
        }
        if (open < max) {
            helper(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            helper(list, str + ")", open, close + 1, max);
        }
    }
}
