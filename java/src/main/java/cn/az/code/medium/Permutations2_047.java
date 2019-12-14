package cn.az.code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author azusachino
 * @version 12/14/2019
 */
public class Permutations2_047 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Permutations2_047 p = new Permutations2_047();
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
