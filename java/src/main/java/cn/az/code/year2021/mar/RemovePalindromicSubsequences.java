package cn.az.code.year2021.mar;

/**
 * @author ycpang
 * @since 2021-03-08 16:55
 */
public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2);
    }
}
