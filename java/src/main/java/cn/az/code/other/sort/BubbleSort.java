package cn.az.code.other.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author az
 * @since 09/08/20
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        System.out.println("一般情况");
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));

        System.out.println("完全逆序");
        values = Sort.of(5, 4, 3, 2, 1);
        sort = new BubbleSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));
    }

    /**
     * 排序主方法
     *
     * @param values 数据
     */
    @Override
    public void sort(T[] values) {
        if (Objects.isNull(values) || values.length == 0) {
            return;
        }
        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[i].compareTo(values[j + 1]) > 0) {
                    T temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
            }
        }
    }
}
