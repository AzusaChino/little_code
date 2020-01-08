package cn.az.code.medium;

import java.util.*;

/**
 * The type Combination sum 2 040.
 *
 * @author azusachino
 * @version 12 /11/2019
 */
public class CombinationSumII040 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CombinationSumII040 combinationSum2040 = new CombinationSumII040();
        System.out.println(combinationSum2040.combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));
    }

    /**
     * Combination sum list.
     *
     * @param nums   the nums
     * @param target the target
     * @return the list
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> tempSet = new HashSet<>();
        Arrays.sort(nums);
        backtrack(tempSet, new ArrayList<>(), nums, target, 0);
        return new ArrayList<>(tempSet);
    }

    private void backtrack(Set<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain > 0) {
            for (int i = start; i < nums.length; i++) {
                int temp = nums[i];
                tempList.add(temp);
                // not i + 1 because we can reuse same elements
                backtrack(list, tempList, nums, remain - temp, i + 1);
                int size = tempList.size();
                tempList.remove(size - 1);
            }
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
    }

    /**
     * Combination sum 2 list.
     *
     * @param candidates the candidates
     * @param target     the target
     * @return the list
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

        if (remain > 0) {
            for (int i = start; i < cand.length; i++) {
                // skip duplicates
                if (i > start && cand[i] == cand[i - 1]) {
                    continue;
                }
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        } else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
    }
}
