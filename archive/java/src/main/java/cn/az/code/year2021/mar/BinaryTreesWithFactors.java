package cn.az.code.year2021.mar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @since 03/13/21 23:14
 */
public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        long res = 0L, mod = (long) 1e9 + 7;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            dp.put(arr[i], 1L);
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % mod);
                }
            }
            res = (res + dp.get(arr[i])) % mod;
        }
        return (int) res;
    }
}
