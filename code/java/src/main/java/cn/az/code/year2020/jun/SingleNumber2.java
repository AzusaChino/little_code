package cn.az.code.year2020.jun;

/**
 * @author az
 * @since 2020-06-22 20:43
 */
public class SingleNumber2 {

    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for (int value : A) {
            ones = (ones ^ value) & ~twos;
            twos = (twos ^ value) & ~ones;
        }
        return ones;
    }
}
