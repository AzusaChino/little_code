package cn.az.code.year2020.sept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author az
 * @since 09/04/20
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println(pl.partitionLabels("ababcbacadefegdehijhklij"));
    }

    //traverse the string record the last index of each char.
    //using pointer to record end of the current sub string.

    /**
     *
     * @param S s
     * @return xxx
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        // record the last index of the each char
        int[] map = new int[26];

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
