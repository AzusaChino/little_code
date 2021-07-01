package cn.az.code.year2021.july;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 2021-07-01
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            list.add((i >> 1) ^ i);
        }
        return list;
    }
}
