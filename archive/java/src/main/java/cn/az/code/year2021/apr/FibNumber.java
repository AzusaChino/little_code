package cn.az.code.year2021.apr;

/**
 * @author ycpang
 * @since 2021-04-15 16:09
 */
public class FibNumber {

    public static void main(String[] args) {
        System.out.println(new FibNumber().fib(4));
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] map = new int[n + 1];
        map[0] = 0;
        map[1] = 1;

        for (int i = 2; i <= n; i++) {
            map[i] = map[i - 1] + map[i - 2];
        }
        return map[n];
    }
}
