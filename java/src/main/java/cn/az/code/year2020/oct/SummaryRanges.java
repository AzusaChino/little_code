package cn.az.code.year2020.oct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 10/28/20
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
                end++;
            }
            if (start == end) {
                list.add(String.valueOf(nums[start]));
            } else {
                list.add(nums[start] + "->" + nums[end]);
            }
            end++;
            start = end;
        }
        return list;
    }

}
