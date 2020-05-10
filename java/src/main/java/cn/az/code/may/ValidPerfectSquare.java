package cn.az.code.may;

/**
 * @author az
 * @date 2020/5/9
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.println(vps.isPerfectSquare(2147483647));
    }

    /**
     * newton
     * @param num num
     * @return valid square
     */
    public boolean perfectSquare(int num) {
        long r = num;
        while(r * r > num) {
            r = (r + num/r) / 2;
        }
        return r*r == num;
    }

    /**
     * time limit exceeded
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int l = 0, r = num;
        while (l < r) {
            int mid = (l + r) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            }
            if (temp > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
            System.out.println("l: " + l + ", r: " + r);
        }
        return false;
    }
}
