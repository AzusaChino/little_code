package cn.az.code.year2020.sept;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author az
 * @since 09/29/20
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> dict) {

        Set<String> set = new HashSet<>(dict);
        // dp[i] == true 代表0-i在字典中存在
        boolean[] dp = new boolean[s.length() + 1];

        // 代表
        dp[0] = true;

        //Second DP
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
