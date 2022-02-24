package cn.az.code.year2020.aug;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author az
 * @since 08/19/20
 */
public class GoatLatin {

    public String toGoatLatin(String S) {
        Set<Character> vowel = "aeiouAEIOU".chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        StringBuilder res = new StringBuilder();
        int i = 0, j;
        for (String w : S.split("\\s")) {
            res.append(' ').append(vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)).append("ma");
            for (j = 0, ++i; j < i; ++j) {
                res.append("a");
            }
        }
        return res.substring(1);
    }

}
