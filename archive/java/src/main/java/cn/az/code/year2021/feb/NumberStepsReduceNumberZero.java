package cn.az.code.year2021.feb;

/**
 * @author ycpang
 * @since 2021-02-12 21:30
 */
public class NumberStepsReduceNumberZero {

    public int numberOfSteps(int num) {
        int steps = 0;

        for (; num > 0; steps++) {
            num = (((num & 1) == 0)) ? num >> 1 : num ^ 1;
        }

        return steps;
    }

}
