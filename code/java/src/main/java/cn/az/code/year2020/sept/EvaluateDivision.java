package cn.az.code.year2020.sept;

import java.util.*;

/**
 * @author az
 * @since 09/27/20
 */
public class EvaluateDivision {

    public static void main(String[] args) {
        EvaluateDivision e = new EvaluateDivision();
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(e.calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        /* Build graph. */
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return result;
    }

    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {

        // Rejection case => ["x", "x"]
        if (!graph.containsKey(start)) {
            return -1.0;
        }

        /* Accepting case. */
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                Double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if (!productWeight.equals(-1.0)) {
                    return neighbour.getValue() * productWeight;
                }
            }
        }

        // for ["a", "a"]
        return -1.0;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>(8);
        String u, v;

        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>(16));
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>(16));
            graph.get(v).put(u, 1 / values[i]);
        }

        return graph;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];

        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String x = eq.get(0), y = eq.get(1);
            String s = String.join(",", equations.get(i));
            map.put(s, values[i]);
            map.put(reverse(s), 1 / map.get(s));
            for (int j = 0; j < equations.size(); j++) {
                if (i == j) {
                    continue;
                }
                List<String> eq2 = equations.get(j);
                if (y.equals(eq2.get(0))) {
                    String s2 = x + "," + eq2.get(1);
                    map.put(s2, values[i] * values[j]);
                    map.put(reverse(s2), 1 / map.get(s2));
                }

            }
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            if (query.get(0).equals(query.get(1))) {
                result[i] = Double.parseDouble("1.0");
            }
            if (map.containsKey(String.join(",", query))) {
                result[i] = map.get(String.join(",", query));
            } else {
                result[i] = Double.parseDouble("-1.0");
            }
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
