package cn.az.code.year2021.jan;

import java.util.stream.LongStream;

/**
 * @author ycpang
 * @since 2021-01-27 16:34
 */
public class ConcatenationConsecutiveBinaryNumbers {

    public int concatenatedBinary(int n) {
        return (int) LongStream.range(1, n + 1).reduce(0, (sum, i) -> (sum * (int) Math.pow(2, Long.toBinaryString(i).length()) + i) % 1_000_000_007);
    }
}
