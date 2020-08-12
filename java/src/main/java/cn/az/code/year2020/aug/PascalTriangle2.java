package cn.az.code.year2020.aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author az
 * @since 08/12/20
 */
public class PascalTriangle2 {

    public static void main(String[] args) {
        PascalTriangle2 pt = new PascalTriangle2();
        System.out.println(pt.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 1) {
            return Collections.singletonList(1);
        }
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        // 添加初始条件 1
        pascalTriangle.add(new ArrayList<>(Collections.singletonList(1)));
        int index = 1;
        while (index <= rowIndex) {
            int[] list = new int[index + 1];
            List<Integer> before = pascalTriangle.get(index - 1);
            for (int i = 0; i < list.length; i++) {
                if (i == 0 || i == list.length - 1) {
                    list[i] = 1;
                    continue;
                }
                list[i] = (before.get(i - 1) + before.get(i));
            }
            pascalTriangle.add(Arrays.stream(list).boxed().collect(Collectors.toList()));
            index++;
            System.out.println(pascalTriangle);
        }
        return pascalTriangle.get(rowIndex);
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = ret.get(j - 1) + ret.get(j);
                ret.set(j, tmp);
            }
            ret.add(1);
        }
        return ret;
    }

    public List<Integer> getRow3(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j >= 1; j--) {
                result[j] += result[j - 1];
            }
        }
        return Arrays.asList(result);
    }

    static class PascalTriangle {

        public List<List<Integer>> generate(int numRows) {

            if (numRows < 1) {
                return Collections.emptyList();
            }
            List<List<Integer>> pascalTriangle = new ArrayList<>();

            // 添加初始条件 1
            pascalTriangle.add(new ArrayList<>(Collections.singletonList(1)));
            int index = 1;
            while (index <= numRows) {
                int[] list = new int[index + 1];
                List<Integer> before = pascalTriangle.get(index - 1);
                for (int i = 0; i < list.length; i++) {
                    if (i == 0 || i == list.length - 1) {
                        list[i] = 1;
                        continue;
                    }
                    list[i] = (before.get(i - 1) + before.get(i));
                }
                pascalTriangle.add(Arrays.stream(list).boxed().collect(Collectors.toList()));
                index++;
            }
            return pascalTriangle;
        }
    }
}
