package cn.az.code.year2021.aug;

/**
 * @author az
 * @since 2021-08-24
 */
public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int[] coefs1 = Stream
            .of(a.split("\\+|i"))
            .mapToInt(Integer::parseInt)
            .toArray(), coefs2 = Stream
            .of(b.split("\\+|i"))
            .mapToInt(Integer::parseInt)
            .toArray();
        return (
            (coefs1[0] * coefs2[0] - coefs1[1] * coefs2[1]) +
            "+" +
            (coefs1[0] * coefs2[1] + coefs1[1] * coefs2[0]) +
            "i"
        );
    }
}
