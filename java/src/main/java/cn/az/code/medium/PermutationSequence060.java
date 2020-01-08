package cn.az.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liz
 * @date 1/6/2020
 */
public class PermutationSequence060 {
    public static void main(String[] args) {
        PermutationSequence060 permutationSequence060 = new PermutationSequence060();
        System.out.println(permutationSequence060.getPermutation(4, 12));
    }

    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            list.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(list.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
}
