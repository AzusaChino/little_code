package cn.az.code.self.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 08/19/20
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        gp.generate(3).forEach(System.out::println);
    }

    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> list, String s, int open, int close, int n) {
        // 长度达到2N
        if (s.length() == 2 * n) {
            list.add(s);
            return;
        }
        // 在（数量小于n时 可以任意添加
        if (open < n) {
            backtrack(list, s + "(", open + 1, close, n);
        }
        // 只有在)数量小于(时, 才可以添加)
        if (close < open) {
            backtrack(list, s + ")", open, close + 1, n);
        }
    }
}
