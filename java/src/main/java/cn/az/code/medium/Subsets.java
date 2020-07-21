package cn.az.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sub set
 * @author Liz
 * @date 1/18/2020
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3};
        Subsets s = new Subsets();
        System.out.println(s.subsetWithDup(nums));
    }

    public List<List<Integer>> subsetWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
