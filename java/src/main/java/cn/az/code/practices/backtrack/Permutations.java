package cn.az.code.practices.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 2/10/2020 16:56
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) {
                    continue; // element already exists, skip
                }
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
