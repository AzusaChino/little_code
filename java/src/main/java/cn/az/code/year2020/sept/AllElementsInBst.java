package cn.az.code.year2020.sept;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author az
 * @since 09/06/20
 */
public class AllElementsInBst {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        leftSubtree(root1, s1);
        leftSubtree(root2, s2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode r1 = s1.peek();
            TreeNode r2 = s2.peek();
            // 交换栈
            if (r1.val > r2.val) {
                result.add(r2.val);
                s2.pop();
                leftSubtree(r2.right, s2);
            } else {
                result.add(r1.val);
                s1.pop();
                leftSubtree(r1.right, s1);
            }

        }

        // 节点数目不一致
        while (!s1.isEmpty()) {
            TreeNode r = s1.pop();
            result.add(r.val);
            leftSubtree(r.right, s1);
        }

        while (!s2.isEmpty()) {
            TreeNode r = s2.pop();
            result.add(r.val);
            leftSubtree(r.right, s2);
        }

        return result;
    }

    private void leftSubtree(TreeNode root, Stack<TreeNode> s) {
        if (root == null) {
            return;
        }
        s.add(root);
        leftSubtree(root.left, s);
    }

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inorder(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        inorder(root2, list2);
        return mergeList(list1, list2);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) list.add(list1.get(i++));
            else list.add(list2.get(j++));
        }

        while (i < list1.size()) list.add(list1.get(i++));
        while (j < list2.size()) list.add(list2.get(j++));

        return list;
    }

    public List<Integer> myGetAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = toList(root1);
        List<Integer> r2 = toList(root2);
        r1.addAll(r2);
        Collections.sort(r1);
        return r1;
    }

    private List<Integer> toList(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            ret.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ret;
    }
}
