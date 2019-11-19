package cn.az.little.medium;

public class ZigZag_006 {

    public static void main(String[] args) {
        System.out.println(zig("PAYPALISHIRING", 3));
    }

    public static String zig(String s, int n) {
        if (n == 1) {
            return s;
        }
        int len = s.length();
        char[] c = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[n];
        for (int i = 0; i < n; i++) {
            sb[i] = new StringBuffer();
        }
        int pointer = 0;
        while (pointer < len) {
            // vertically down
            for (int idx = 0; idx < n && pointer < len; idx++) {
                sb[idx].append(c[pointer++]);
            }
            // obliquely up
            for (int idx = n - 2; idx >= 1 && pointer < len; idx--) {
                sb[idx].append(c[pointer++]);
            }
        }
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
