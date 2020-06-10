package cn.az.code.year2020.jun;

import java.util.*;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null) {
                idx[t.charAt(i)] = new ArrayList<>();
            }
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            // Note: char of S does NOT exist in T causing NPE
            if (idx[s.charAt(i)] == null) {
                return false;
            }
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) {
                j = -j - 1;
            }
            if (j == idx[s.charAt(i)].size()) {
                return false;
            }
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }

    public boolean is_subsequence(String s, String t){
        if (s.length() == 0) {
            return true;
        }
        // 双指针
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
            indexT++;
        }
        return false;
    }

}
