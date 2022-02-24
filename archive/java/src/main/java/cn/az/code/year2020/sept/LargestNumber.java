package cn.az.code.year2020.sept;

import java.util.Arrays;

/**
 * @author az
 * @since 09/26/20
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        // Convert int array to String array, so we can sort later on
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        // Comparator to decide which string should come first in concatenation
        Arrays.sort(strings, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (strings[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }

        return sb.toString();

    }
}
