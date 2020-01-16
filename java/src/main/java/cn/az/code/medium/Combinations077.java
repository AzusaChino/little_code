package cn.az.code.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liz
 * @date 1/16/2020
 */
public class Combinations077 {

    public static void main(String[] args) {
        Combinations077 c = new Combinations077();
        System.out.println(c.combine(4, 4));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k == n) {
            return new ArrayList<>(Collections.singletonList(Stream.iterate(n, i -> i - 1).limit(n).collect(Collectors.toList())));
        }
        List<List<Integer>> res = this.combine(n - 1, k - 1);
        res.forEach(i -> i.add(n));
        res.addAll(combine(n - 1, k));
        return res;
    }
}
