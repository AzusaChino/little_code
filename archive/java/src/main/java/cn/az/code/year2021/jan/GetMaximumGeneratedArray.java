package cn.az.code.year2021.jan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ycpang
 * @since 2021/1/15 16:45
 */
public class GetMaximumGeneratedArray {

    public static void main(String[] args) {
        GetMaximumGeneratedArray gma = new GetMaximumGeneratedArray();
        System.out.println(gma.getMaximumGenerated(7));

    }

    public int getMaximumGenerated(int n) {

        return generate(n).stream().max(Comparator.comparingInt(x -> x)).get();
    }

    public List<Integer> generate(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.add(0);
            } else if (i == 1) {
                list.add(1);
            } else {
                if ((i & 1) != 0) {
                    list.add(list.get(i / 2));
                } else {
                    list.add(list.get(i / 2 + 1) + list.get(i / 2));
                }
            }
        }

        return list;
    }
}
