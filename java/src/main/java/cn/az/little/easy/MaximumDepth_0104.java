package cn.az.little.easy;

import cn.az.little.common.TreeNode;

import java.util.Objects;

/**
 * @author : Liz
 * @date : 2019/11/8
 **/
public class MaximumDepth_0104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(solution(root));
    }

    public static int solution(TreeNode root) {
        return Objects.isNull(root) ? 0 : 1 + Math.max(solution(root.left), solution(root.right));
    }
}
