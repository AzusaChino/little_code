package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/10/28
 **/
public class ImplementStr {

    public static void main(String[] args) {
        System.out.println(implement("hello","ll"));
    }

    public static int implement(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }
}
