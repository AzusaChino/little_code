package cn.az.code.year2020.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 08/06/20
 */
public class FindDuplicateArray {

    public List<Integer> findDup(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                res.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }
        return res;
    }
}
