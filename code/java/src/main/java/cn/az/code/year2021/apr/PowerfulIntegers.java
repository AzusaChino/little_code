package cn.az.code.year2021.apr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author az
 * @since 2021-04-30
 */
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();

        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                s.add(i + j);
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;
        }
        return new ArrayList<>(s);
    }
}