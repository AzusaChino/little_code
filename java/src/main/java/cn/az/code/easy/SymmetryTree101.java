package cn.az.code.easy;

import cn.az.code.common.TreeNode;

import java.util.Objects;

/**
 * @author : Liz
 * @date : 2019/11/7
 **/
public class SymmetryTree101 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(1);
        t.right = new TreeNode(1);
        System.out.println(s1(t));
    }

    public static boolean s1(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        return s2(root.left, root.right);

    }

    public static boolean s2(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) || Objects.isNull(right)) {
            return left == right;
        }
        return left.val == right.val && s2(left.left, right.right) && s2(left.right, right.left);
    }
}
