package cn.az.code.year2021.may;

/**
 * @author az
 * @since 2021-05-26
 */
public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); ++i)
            res = Math.max(res, n.charAt(i) - '0');
        return res;
    }

    public int _minPartitions(String n) {
        return n.chars().max().getAsInt() - '0';
    }
}