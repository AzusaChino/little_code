package cn.az.code.year2020.aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author az
 * @since 08/18/20
 */
public class NumbersWithSameConsecutiveDifferences {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(NumbersWithSameConsecutiveDifferences.numsSameConsecDiff(3, 7)));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        List<Integer> cur = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                // x > 0 => 防止前置0
                // y 总是个位 -> (1+8) < 10 -> 1,8,1
                if (x > 0 && y + K < 10) {
                    cur2.add(x * 10 + y + K);
                }
                // 7, 0, 7
                if (x > 0 && K > 0 && y - K >= 0) {
                    cur2.add(x * 10 + y - K);
                }
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(j -> j).toArray();
    }
}
