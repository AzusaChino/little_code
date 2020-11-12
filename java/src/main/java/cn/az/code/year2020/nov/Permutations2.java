package cn.az.code.year2020.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author az
 * @since 11/12/20
 */
public class Permutations2 {

    public static void main(String[] args) {
        Permutations2 p2 = new Permutations2();
        System.out.println(p2.permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        dfs(list, new ArrayList<>(), nums, new boolean[nums.length]);

        return list;
    }

    private void dfs(List<List<Integer>> list, List<Integer> cur, int[] nums, boolean[] visited) {
        if (cur.size() == nums.length) {
            list.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
                    continue;
                }
                visited[i] = true;
                cur.add(nums[i]);
                dfs(list, cur, nums, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
