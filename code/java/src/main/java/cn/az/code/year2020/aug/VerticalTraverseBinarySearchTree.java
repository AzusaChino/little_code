package cn.az.code.year2020.aug;

import cn.az.code.common.TreeNode;

import java.util.*;

/**
 * @author az
 * @since 08/07/20
 */
public class VerticalTraverseBinarySearchTree {
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    int minX = 0, maxX = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> vertical = new ArrayList<>();
        for (int i = minX; i <= maxX; i++) {
            List<Integer> level = new ArrayList<Integer>();
            for (int key : map.get(i).keySet()) {
                while (!(map.get(i).get(key)).isEmpty()) {
                    level.add(map.get(i).get(key).poll());
                }
            }
            vertical.add(level);
        }
        return vertical;

    }

    private void helper(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        map.computeIfAbsent(x, k -> new TreeMap<>());
        if (map.get(x).get(y) == null) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).add(node.val);
        helper(node.left, x - 1, y + 1);
        helper(node.right, x + 1, y + 1);

    }

    static class OtherVersion {
        public List<List<Integer>> verticalTraverse(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            helper(map, 0, root);
            return new ArrayList<>(map.values());
        }

        private void helper(Map<Integer, List<Integer>> map, int cur, TreeNode node) {
            if (node == null) {
                return;
            }
            map.computeIfAbsent(cur, k -> new ArrayList<>());
            map.computeIfPresent(cur, (k, v) -> {
                v.add(node.val);
                return v;
            });

            helper(map, cur - 1, node.left);
            helper(map, cur + 1, node.right);
        }
    }


}
