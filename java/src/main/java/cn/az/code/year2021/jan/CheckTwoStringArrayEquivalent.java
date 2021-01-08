package cn.az.code.year2021.jan;

/**
 * @author ycpang
 * @since 2021/1/8 16:25
 */
public class CheckTwoStringArrayEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        return String.join("", word1).equals(String.join("", word2));
    }
}
