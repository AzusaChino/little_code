package cn.az.code.year2021.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author az
 * @since 2021-07-09
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }
}
