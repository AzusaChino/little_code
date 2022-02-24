package cn.az.code.medium;

/**
 * Integer 2 Roman
 *
 * @author Liz
 * @version 2019/11/22
 */
public class IntegerRoman {

    public static void main(String[] args) {
        System.out.println(convert(123));
        System.out.println(convert(322));
    }

    private static String convert(int num) {
        int max = 3999;
        if (num < 1 || num > max) {
            return "";
        }
        String[] m = new String[]{"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num / 1000] + c[(num % 1000) / 100] + x[(num % 100) / 10] + i[num % 10];
    }
}
