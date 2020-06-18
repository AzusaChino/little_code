package cn.az.code.other.string;

/**
 * @author az
 * @since 2020-06-18 22:37
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }

        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
