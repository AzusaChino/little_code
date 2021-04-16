package cn.az.code.year2021.apr;

/**
 * @author ycpang
 * @since 2021-04-16 15:54
 */
public class RemoveAllAdjacentDuplicatesString2 {

    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();

        for (int j = 0; j < n; ++i, ++j) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == i) {
                i -= k;
            }
        }

        return new String(stack, 0, i);
    }

}
