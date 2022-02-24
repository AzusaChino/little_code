package cn.az.code.year2021.feb;

/**
 * @author ycpang
 * @since 2021-02-01 16:34
 */
public class NumberOfOneBits {

    public static void main(String[] args) {
        NumberOfOneBits n = new NumberOfOneBits();
        int k = 11;
        System.out.println(n.hammingWeight(k));
    }

    // you need to treat n as an unsigned value

    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
}
