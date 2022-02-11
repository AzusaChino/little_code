package cn.az.code.practices.recursion;

/**
 * @author az
 * @date 5/4/2020
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = "Hello".toCharArray();
        rs.reverseString(s);
        System.out.println(s);
    }

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
