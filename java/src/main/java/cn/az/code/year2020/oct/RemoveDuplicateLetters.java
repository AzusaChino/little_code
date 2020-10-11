package cn.az.code.year2020.oct;

/**
 * @author az
 * @since 10/11/20
 */
public class RemoveDuplicateLetters {

    public String remove(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + remove(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
