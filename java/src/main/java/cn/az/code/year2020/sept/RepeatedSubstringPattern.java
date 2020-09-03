package cn.az.code.year2020.sept;

/**
 * @author az
 * @since 09/03/20
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        System.out.println(rsp.repeatedSubstringPattern("abaabaa"));
    }

    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }

    public boolean repeated(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) {
            // 整除 -> 即能分成多少份
            if (len % i == 0) {
                // size即为份数
                int size = len / i;
                String subS = s.substring(0, i);
                int j;
                for (j = 1; j < size; j++) {
                    if (!subS.equals(s.substring(j * i, i + j * i))) {
                        break;
                    }
                }
                if (j == size) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean myWrongRepeatedSubstringPattern(String s) {

        if (s == null || s.length() <= 1) {
            return false;
        }
        int len = s.length();
        int interval = intervalHelper(s);
        if (interval < 0 || (len % interval) != 0) {
            return false;
        }
        String sample = s.substring(0, interval);
        int prev = 0;
        while ((prev + interval) <= len) {
            if (!sample.equals(s.substring(prev, prev + interval))) {
                return false;
            }

            prev += interval;
        }
        return true;
    }

    // 错因在于 只返回了一个interval, 应该进行遍历
    private int intervalHelper(String s) {
        int len = s.length(), half = len / 2;
        for (int i = 1; i <= half; i++) {
            for (int j = i + 1; j <= len; j++) {
                // 防止多跑路
                if ((j - i) > i) {
                    break;
                }
                String left = s.substring(0, i);
                String right = s.substring(i, j);
                if (left.equals(right)) {
                    return j - i;
                }
            }
        }
        return -1;
    }
}
