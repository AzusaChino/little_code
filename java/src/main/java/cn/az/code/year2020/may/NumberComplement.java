package cn.az.code.year2020.may;

/**
 * @author az
 * @date 5/4/2020
 */
public class NumberComplement {

    /**
     * what is the relationship between input and output
     * input + output = 111....11 in binary format
     * Is there any corner case?
     * 0 is a corner case expecting 1, output > input
     *
     * @param num num
     * @return complement
     */
    public int findComplement(int num) {
        //x = 1 => 1 => 1
        //x = 3 => (2*1 + 1) => 11
        //x = 7 => (3*2 + 1) => 111
        //x = 15 => (7*2 + 1) => 1111
        int x = 1;
        while (num > x) {
            x = x * 2 + 1;
        }
        return x - num;
    }
}
