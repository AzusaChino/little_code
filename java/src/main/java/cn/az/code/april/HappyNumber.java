package cn.az.code.april;

import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @date 2020/4/20
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(18));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int remain;
        while (set.add(n)) {
            int squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            System.out.println(squareSum);
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }
}
