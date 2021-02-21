package cn.az.code.year2021.feb;

/**
 * @author ycpang
 * @since 2021-02-21 16:46
 */
public class BrokenCalculator {

    public static void main(String[] args) {
        BrokenCalculator bc = new BrokenCalculator();
        System.out.println(bc.brokenCalc(2, 3));
    }

    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        return res + X - Y;
    }

}
