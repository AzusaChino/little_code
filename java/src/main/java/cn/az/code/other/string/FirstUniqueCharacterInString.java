package cn.az.code.other.string;

/**
 * @author az
 * @since 2020-06-18 22:06
 */
public class FirstUniqueCharacterInString {

    public int firstUniqueChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
