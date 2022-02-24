package cn.az.code.year2020.jun;

public class ReverseString {

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    public void helper(char[] s, int l, int r) {
        if (l == r || l - r == 1) {
            return;
        }
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        helper(s, l + 1, r - 1);
    }
}
