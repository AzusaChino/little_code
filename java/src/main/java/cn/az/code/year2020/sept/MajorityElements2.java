package cn.az.code.year2020.sept;

import java.util.ArrayList;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 22/9/2020 21:03
 */
public class MajorityElements2 {

    public List<Integer> majority(int[] nums) {
        // different value for first loop
        int first = 0, second = 1;
        int firstCount = 0, secondCount = 0;
        for (int num : nums) {
            if (num == first) {
                firstCount++;
            } else if (num == second) {
                secondCount++;
            } else if (firstCount == 0) {
                first = num;
                firstCount = 1;
            } else if (secondCount == 0) {
                second = num;
                secondCount = 1;
            } else {
                firstCount--;
                secondCount--;
            }
        }
        firstCount = secondCount = 0;
        for (int num : nums) {
            if (first == num) {
                firstCount++;
            }
            if (second == num) {
                secondCount++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (firstCount > nums.length / 3) {
            result.add(first);
        }
        if (secondCount > nums.length / 3) {
            result.add(second);
        }
        return result;
    }


}
