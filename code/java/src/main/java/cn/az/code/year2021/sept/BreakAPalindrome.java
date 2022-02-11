package cn.az.code.year2021.sept;

/**
 * @author az
 * @since 2021-9-23
 */
public class BreakAPalindrome {

    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(s);
    }
}
