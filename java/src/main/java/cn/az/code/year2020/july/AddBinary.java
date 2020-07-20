package cn.az.code.year2020.july;

import java.math.BigInteger;

/**
 * @author az
 * @since 07/19/20
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("1011", "1011"));
    }

    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }

    public String _addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        while (i >= 0 && j >= 0) {
            sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        while (i >= 0) {
            sum = a.charAt(i--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        while (j >= 0) {
            sum = b.charAt(j--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String __addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
