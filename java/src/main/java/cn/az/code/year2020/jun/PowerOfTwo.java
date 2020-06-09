package cn.az.code.year2020.jun;

public class PowerOfTwo {

    public static void main(String[] args) {
        PowerOfTwo pt = new PowerOfTwo();
        System.out.println(pt.isPowerOfTwo(12));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if ((n & 1) == 1) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
