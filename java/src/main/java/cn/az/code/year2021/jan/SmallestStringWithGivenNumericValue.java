package cn.az.code.year2021.jan;

import java.util.Arrays;

/**
 * @author ycpang
 * @since 2021-01-28 17:16
 */
public class SmallestStringWithGivenNumericValue {

    // Build the string of length k, which consists of letter 'a' (lexicographically smallest string).
    // Increment string from right to left until it's value won't reach the target.

    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        k -= n;
        while (k > 0) {
            if (chars[n - 1] < 'z') {
                chars[n - 1]++;
                k--;
            } else {
                n--;
            }
        }
        return new String(chars);
    }
}
