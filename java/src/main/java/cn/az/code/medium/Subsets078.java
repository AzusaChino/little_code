package cn.az.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liz
 * @date 1/17/2020
 */
public class Subsets078 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Subsets078 s = new Subsets078();
        System.out.println(s.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
