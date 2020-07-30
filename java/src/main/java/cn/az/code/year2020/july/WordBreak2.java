package cn.az.code.year2020.july;

import java.util.*;

/**
 * @author az
 * @since 07/30/20
 */
public class WordBreak2 {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        WordBreak2 wb2 = new WordBreak2();
        String s = "applepen";
        Set<String> dict = new HashSet<>(Arrays.asList("apple", "pen", "pine"));
        System.out.println(wb.wordBreak(s, dict));
        System.out.println(wb2.wordBreak(s, dict));
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>(16));
    }


    List<String> DFS(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    static class WordBreak {
        public boolean wordBreak(String s, Set<String> dict) {

            // dp[i] == true 代表0-i在字典中存在
            boolean[] dp = new boolean[s.length() + 1];

            // 代表
            dp[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(dp[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

            //Second DP
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i; j >= 0; j--) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
