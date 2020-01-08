package cn.az.code.easy;

/**
 * @author : Liz
 * @date : 2019/11/1
 **/
public class AddBinary067 {

    public static void main(String[] args) {
        System.out.println(addBinary("1001", "1011"));
    }

    public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aChar;
        int bChar;
        int carry = 0;
        int result;
        while (i >= 0 || j >= 0 || carry == 1) {
            aChar = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bChar = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aChar ^ bChar ^ carry;
            carry = ((aChar + bChar + carry) >= 2) ? 1 : 0;
            sb.append(result);
        }
        return sb.reverse().toString();
    }
}
