package cn.az.little.medium;

public class String2Integer_008 {
    public static void main(String[] args) {
        System.out.println(convert("-02123"));
    }

    public static int convert(String str) {
        int pointer = 0;
        int res = 0;
        int len = str.length();
        if (len == 0) {
            return res;
        }
        while(pointer < len && Character.isWhitespace(str.charAt(pointer))) {
            pointer++;
        }
        if (pointer == len) {
            return res;
        }
        char p = '+', n = '-';
        boolean negativeFlag = (str.charAt(pointer) == n);
        if (str.charAt(pointer) == p || str.charAt(pointer) == n) {
            pointer++;
        }
        for(; pointer < len; pointer++) {
            if(str.charAt(pointer) > '9' || str.charAt(pointer) < '0') {
                break;
            } else {
                // calculate the diff
                int digit = str.charAt(pointer) - '0';
                if (!negativeFlag && res > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (negativeFlag && res < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + (negativeFlag? -digit : digit);
            }
        }
        return res;
    }
}
