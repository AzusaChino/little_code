package cn.az.code.year2020.dec;

import java.util.ArrayList;
import java.util.List;

public class KthFactorOfN {

    public int kthFactor(int n, int k) {
        for (int factor = 1; factor <= n; ++factor) {
            if (n % factor == 0 && --k == 0) {
                return factor;
            }
        }
        return -1;
    }

    public int _kthFactor(int n, int k) {
        List<Integer> factorList = new ArrayList<>();
        for (int factor = 1; factor * factor <= n; ++factor) {
            if (n % factor == 0) {
                if (factor * factor != n) {
                    factorList.add(factor);
                }
                if (--k == 0) {
                    return factor;
                }
            }
        }
        int size = factorList.size();
        return k > size ? -1 : n / factorList.get(size - k);
    }
}
