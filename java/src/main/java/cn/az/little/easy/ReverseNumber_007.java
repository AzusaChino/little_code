package cn.az.little.easy;

/**
 * @author : Liz
 * @date : 2019/10/21
 **/
public class ReverseNumber_007 {

    public static void main(String[] args) {
        ReverseNumber_007 r = new ReverseNumber_007();
        System.out.println(r.reverse(9982));
    }

    public int reverse(int input) {
        long output = 0;
        while (input != 0) {
            output = output * 10 + input % 10;
            input /= 10;
            if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) output;
    }
}
