package cn.az.code.year2020.july;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 07/24/20
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(res, 0, graph, path);
        return res;
    }

    private void dfs(List<List<Integer>> res, int node, int[][] graph, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(res, nextNode, graph, path);
            path.remove(path.size() - 1);
        }
    }
}
