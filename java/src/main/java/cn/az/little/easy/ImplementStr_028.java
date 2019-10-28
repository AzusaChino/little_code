package cn.az.little.easy;

/**
 * @author : Liz
 * @date : 2019/10/28
 **/
public class ImplementStr_028 {

    public static void main(String[] args) {

    }

    public static int implement(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return 0;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
