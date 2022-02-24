package cn.az.code.year2020.april;

/**
 * @author az
 * @date 2020/4/29
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString("(*))"));
    }

    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) {
                break;
            }
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    public boolean _checkValidString(String s) {
        int low = 0, high = 0;
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;

                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }
}
