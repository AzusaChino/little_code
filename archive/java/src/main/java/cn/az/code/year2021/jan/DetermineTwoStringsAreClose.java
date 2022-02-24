package cn.az.code.year2021.jan;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ycpang
 * @since 2021-01-22 16:15
 */
public class DetermineTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        int[] w1 = new int[26], w2 = new int[26], w3 = new int[26], w4 = new int[26];

        for (char c : word1.toCharArray()) {
            w1[c - 'a']++;
            w3[c - 'a'] = 1;
        }

        for (char c : word2.toCharArray()) {
            w2[c - 'a']++;
            w4[c - 'a'] = 1;

        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        return toString(w1).equals(toString(w2)) && toString(w3).equals(toString(w4));
    }


    public String toString(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
