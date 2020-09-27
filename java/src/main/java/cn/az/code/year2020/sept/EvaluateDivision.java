package cn.az.code.year2020.sept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author az
 * @since 09/27/20
 */
public class EvaluateDivision {

    public double[] evaluate(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];

        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String x = eq.get(0), y = eq.get(1);
            String s = String.join(",", equations.get(i));

        }

        return result;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
