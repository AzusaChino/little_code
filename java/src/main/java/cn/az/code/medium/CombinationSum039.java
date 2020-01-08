package cn.az.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author azusachino
 * @version 12/10/2019
 */
public class CombinationSum039 {

    public static void main(String[] args) {
        CombinationSum039 combinationSum039 = new CombinationSum039();
        System.out.println(combinationSum039.combinationSum(new int[]{1, 2, 3, 4}, 2));
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                // not i + 1 because we can reuse same elements
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
