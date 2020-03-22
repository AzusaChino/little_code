package cn.az.code.easy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : Liz
 * @date : 2019/10/22
 **/
public class PalindromeNumber009 {

    public static void main(String[] args)
    {
        System.out.println(find(989));
        System.out.println(new PalindromeNumber009().isPalindrome("i like u ekil i"));
    }


    public boolean isPalindrome(String s) {

        String filteredS = _filterNonNumberAndChar(s);

        String reversedS = _reverseString(s);
        return filteredS.equalsIgnoreCase(reversedS);
    }

    private String _reverseString(String filteredS) {
        return new StringBuilder(filteredS).reverse().toString();
    }

    private String _filterNonNumberAndChar(String s) {
        return s.replaceAll("/[^A-Za-z0-9 ]/", "");
    }

    public static boolean find(int x) {
        if (x < 0) {
            return false;
        } else {
            return x == Integer.parseInt(StringUtils.reverse(String.valueOf(x)));
        }
    }
}
