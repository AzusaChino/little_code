package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 09/24/20
 */
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int si = 0, ti = 0;
        for (char ss : s.toCharArray()) {
            si += ss;
        }
        for (char tt : t.toCharArray()) {
            ti += tt;
        }
        return (char) (ti - si);
    }
}
