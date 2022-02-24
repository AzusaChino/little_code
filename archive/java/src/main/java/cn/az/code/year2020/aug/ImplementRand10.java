package cn.az.code.year2020.aug;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author az
 * @since 08/28/20
 */
public class ImplementRand10 {

    public static void main(String[] args) {
        ImplementRand10 i = new ImplementRand10();
        for (int j = 0; j < 10; j++) {
            System.out.println(i.rand10());
        }
    }

    public int rand7() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Random random = new Random();
        return list.get(random.nextInt(6));
    }

    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }
}
