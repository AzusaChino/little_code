package cn.az.code.year2021.apr;

/**
 * @author az
 * @since 2021-04-27
 */
public class PowerOfThree {

    public boolean isPower(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}