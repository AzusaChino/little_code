package cn.az.code.easy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : Liz
 * @date : 2019/10/22
 **/
public class PalindromeNumber009 {

    public static void main(String[] args) {
        System.out.println(find(989));
    }

    public static boolean find(int x) {
        if (x < 0) {
            return false;
        } else {
            return x == Integer.parseInt(StringUtils.reverse(String.valueOf(x)));
        }
    }
}
