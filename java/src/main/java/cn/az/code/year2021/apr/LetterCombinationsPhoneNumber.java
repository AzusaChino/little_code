package cn.az.code.year2021.apr;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ycpang
 * @since 2021-04-08 17:15
 */
public class LetterCombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        // initial state
        ans.add("");
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        while (ans.peek() != null && ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }
}
