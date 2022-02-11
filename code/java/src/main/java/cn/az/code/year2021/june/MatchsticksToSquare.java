package cn.az.code.year2021.june;

import java.util.Arrays;

/**
 * @author az
 * @since 2021-06-15
 */
public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4)
            return false;
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return dfs(matchsticks, new int[4], 0, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] sums, int index, int target) {
        if (index == matchsticks.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > target)
                continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, sums, index + 1, target))
                return true;
            sums[i] -= matchsticks[index];
        }

        return false;
    }

    private void reverse(int[] matchsticks) {
        int i = 0, j = matchsticks.length - 1;
        while (i < j) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
            i++;
            j--;
        }
    }

}
