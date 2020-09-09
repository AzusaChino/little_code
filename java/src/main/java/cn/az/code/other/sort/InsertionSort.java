package cn.az.code.other.sort;

import java.util.Arrays;

/**
 * @author az
 * @since 09/09/20
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    public static void main(String[] args) {
        System.out.println("一般情况");
        Integer[] values = Sort.of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));

        System.out.println("完全逆序");
        values = Sort.of(5, 4, 3, 2, 1);
        sort = new InsertionSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));
    }

    /**
     * 排序主方法
     *
     * @param values 数据
     */
    @Override
    public void sort(T[] values) {
        // 从1开始， 0已排序
        for (int i = 1; i < values.length; i++) {
            T t = values[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && values[j - 1].compareTo(t) > 0) {
                    // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
                    values[j] = values[j - 1];
                    System.out.println("Temping:  " + Arrays.toString(values));
                } else {
                    // 将新元素插入到该位置后
                    values[j] = t;
                    System.out.println("Sorting:  " + Arrays.toString(values));
                    break;
                }
            }
        }
    }
}
