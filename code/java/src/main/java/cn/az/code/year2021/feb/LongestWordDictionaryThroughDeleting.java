package cn.az.code.year2021.feb;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ycpang
 * @since 2021-02-22 16:17
 */
public class LongestWordDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        d.sort((a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }


    public String __findLongestWord__(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }

            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }

    public String findLongestWord1(String s, List<String> d) {

        // 1. find all valid strings(sub sequence)

        List<String> filtered = d.stream().filter(x -> isSubSequence(s, x)).collect(Collectors.toList());

        // 2. find the smallest lexicographical
        if (filtered.isEmpty()) {
            return "";
        }
        return filtered.stream().sorted().findFirst().get();
    }

    private boolean isSubSequence(String str1, String str2) {
        int i = 0;
        for (char c : str1.toCharArray()) {
            if (i < str2.length() && c == str2.charAt(i)) {
                i++;
            }
        }
        return i == str2.length();
    }
}
