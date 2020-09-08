package cn.az.code.other.sort;

/**
 * @author az
 * @since 09/08/20
 */
public interface Sorter<T> {

    /**
     * 排序主方法
     *
     * @param ts 数据
     */
    void sort(T[] ts);
}
