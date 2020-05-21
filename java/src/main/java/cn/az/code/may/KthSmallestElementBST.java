package cn.az.code.may;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author az
 * @date 2020/5/21
 */
public class KthSmallestElementBST {

    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            // 1 is counted as current node
            return kthSmallest(root.right, k - 1 - count);
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) {
            return 0;
        }

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) {
                return n.val;
            }
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }

    public int kthSmallest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        Collections.sort(list);
        return list.get(k - 1);
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            traverse(root.left, list);
            traverse(root.right, list);
        }
    }
}
