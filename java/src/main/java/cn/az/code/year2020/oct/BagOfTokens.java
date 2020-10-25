package cn.az.code.year2020.oct;

import java.util.Arrays;

/**
 * @author az
 * @since 10/24/20
 */
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        // 排序
        Arrays.sort(tokens);
        int res = 0, points = 0, i = 0, j = tokens.length - 1;
        // 如果P大于token, score++
        // 如果P小于TOKEN, 且score大于0, 获取power, score--
        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                break;
            }
        }
        return res;
    }
}
