package cn.az.code.year2021.june;

/**
 * @author az
 * @since 2021-06-28
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

    public String _removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.setLength(len - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }

}
