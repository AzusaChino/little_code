package cn.az.code.year2020.jun;

import java.util.*;

/**
 * @author az
 * @since 2020-06-13 22:24
 */
public class LargestDivisibleSubset {

    public List<Integer> _largestDivisibleSubset(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.stream(nums).forEach(v -> {
            List<Integer> prefix = new ArrayList<>(results.stream().filter(l -> v % l.get(l.size() - 1) == 0).max(Comparator.comparing(List::size)).orElse(Collections.emptyList()));
            prefix.add(v);
            results.add(prefix);
        });
        return results.stream().max(Comparator.comparing(List::size)).orElse(Collections.emptyList());
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
