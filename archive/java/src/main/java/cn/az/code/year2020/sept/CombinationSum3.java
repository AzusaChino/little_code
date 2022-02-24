package cn.az.code.year2020.sept;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 09/12/20
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
//        System.out.println(cs3.combinationSum3(3, 7));
        System.out.println(cs3.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
