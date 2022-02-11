package cn.az.code.practices.sort;

/**
 * @author az
 * @since 09/08/20
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 工厂方法
     * @param values 数据
     * @param <T> 泛型
     * @return 数组
     */
    @SafeVarargs
    static <T> T[] of(T... values) {
        return values;
    }

    /**
     * 排序主方法
     *
     * @param values 数据
     */
    void sort(T[] values);
}
