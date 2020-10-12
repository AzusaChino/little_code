package cn.az.code.other.untag;

import java.util.HashSet;
import java.util.Set;

/**
 * @author az
 * @since 10/12/20
 */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(2));
    }

    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();
        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }

        }
        return false;
    }
}
