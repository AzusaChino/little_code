package cn.az.code.medium;

/**
 * @author azusachino
 * @version 2019/12/18
 */
public class ImplementPow050 {
    public static void main(String[] args) {
        ImplementPow050 i= new ImplementPow050();
        System.out.println(i.pow(2.0,4));
    }

    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.;
        }
        double res = myPow(x, n / 2);
        return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
    }

    public double pow(double x, int n) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while(n>0){
            if((n&1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
