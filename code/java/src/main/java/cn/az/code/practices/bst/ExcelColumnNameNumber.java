package cn.az.code.practices.bst;

/**
 * @author az
 * @since 08/10/20
 */
public class ExcelColumnNameNumber {

    public int toNumber(String s) {
        char[] chs = s.toCharArray();
        int res = 0, count = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            res += (chs[i] - 'A' + 1) * Math.pow(26, count++);
        }
        return res;
    }

    public int toNum(String s) {
        return s.chars().reduce(0, (r, ch) -> r * 26 + (ch - 'A' + 1));
    }
}
