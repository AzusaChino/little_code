package cn.az.code.year2020.aug;

/**
 * @author az
 * @since 08/02/20
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        // case 1: ALL capital
        if (word.equals(word.toUpperCase())) {
            return true;
        }

        // case 2: Only First capital
        if (word.substring(0,1).equals(word.substring(0,1).toUpperCase())
        && word.substring(1).equals(word.substring(1).toLowerCase())) {
            return true;
        }

        // case 3: no capital
        if (word.equals(word.toLowerCase())) {
            return true;
        }

        return false;
    }
}
