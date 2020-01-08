package cn.az.code.medium;

/**
 * @author Liz
 * @version 2019/12/3
 */
public class DivideInteger029 {

    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
        System.out.println(divide(Integer.MIN_VALUE,-1));
    }

    public static int divide(int dividend, int divisor) {
        int result;
        int flag = dividend*divisor>0? 1 : -1;
        for (int i = 0;; i++) {
            int temp = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
            if (Math.abs(divisor)*i >  temp) {
                result = i - 1;
                break;
            }
        }
        return result * flag;
    }
    public int divide2(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        if (dividend != Integer.MIN_VALUE
                && Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }

        boolean flag = (dividend < 0) ^ (divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int[] num = new int[40];
        int[] multiple = new int[40];
        num[1] = divisor;
        multiple[1] = 1;

        for (int i = 2; i < 32 && num[i - 1] < 0; ++i) {
            num[i] = num[i - 1] << 1;
            multiple[i] = multiple[i - 1] << 1;
        }

        int result = 0;
        int index = 1;
        while (num[index] < 0) {
            ++index;
        }
        index -= 1;

        while (dividend <= divisor) {
            while (dividend <= num[index]) {
                result += multiple[index];
                dividend -= num[index];
            }
            --index;
        }
        return !flag ? result : -result;
    }
}
