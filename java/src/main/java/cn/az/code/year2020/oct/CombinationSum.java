package cn.az.code.year2020.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 2/10/2020 16:01
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(cs.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        // 为了保证start从小数开始
        Arrays.sort(candidates);
        dfs(ret, new ArrayList<>(), candidates, target, 0);

        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            temp.add(candidate);
            dfs(ret, temp, candidates, target - candidate, i);
            temp.remove(temp.size() - 1);
        }
    }
}
