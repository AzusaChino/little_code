package cn.az.code.year2020.july;

/**
 * @author az
 * @since 2020-07-01 23:15
 */
public class ArrangingCoins {

    public static void main(String[] args) {
        System.out.println(ArrangingCoins.arrangeCoins(3));
    }

    public static int arrangeCoins(int n) {

        if (n == 1) {
            return 1;
        }
        int i = 1;
        while (i <= n) {
            n -= i;
            i++;
        }
        return i - 1;
    }

}
