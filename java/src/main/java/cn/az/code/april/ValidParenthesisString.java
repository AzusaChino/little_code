package cn.az.code.april;

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
