package cn.az.code.year2021.july;

/**
 * @author az
 * @since 2021-07-22
 */
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else
                max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }
}
