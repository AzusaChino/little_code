package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/22
 **/
public class PalindromeNumber009 {

    public static void main(String[] args)
    {
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

}
