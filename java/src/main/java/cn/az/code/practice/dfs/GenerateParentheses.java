package cn.az.code.practice.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 09/09/20
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generate(2));
    }

    public List<String> generate(int n) {
        List<String> ret = new ArrayList<>();
        dfs(ret, n, "", 0, 0);
        return ret;
    }

    private void dfs(List<String> ret, int n, String s, int left, int right) {
        if (left == n && right == n) {
            ret.add(s);
            return;
        }
        if (left < n) {
            dfs(ret, n, s + "(", left + 1, right);
        }
        if (right < n && right < left) {
            dfs(ret, n, s + ")", left, right + 1);
        }
    }

}
