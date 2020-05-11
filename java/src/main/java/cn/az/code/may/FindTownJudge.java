package cn.az.code.may;

import java.util.HashMap;
import java.util.Map;

/**
 * @author az
 * @date 5/11/2020
 */
public class FindTownJudge {

    public int find(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t : trust) {
           count[t[0]]--;
           count[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N-1) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> map = new HashMap<>(N);

        for (int i = 1; i <= N; i++) {
            map.putIfAbsent(i, 0);
        }

        for (int[] t : trust) {
            map.compute(t[1], (k, v) -> v + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
