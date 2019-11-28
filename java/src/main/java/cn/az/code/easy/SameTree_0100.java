package cn.az.code.easy;

import cn.az.code.common.TreeNode;

import java.util.Objects;

/**
 * @author : Liz
 * @date : 2019/11/6
 **/
public class SameTree_0100 {

    public static void main(String[] args) {

        System.out.println(same(null, null));
    }

    public static boolean same(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        } else if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        } else {
            if (p.val == q.val) {
                return same(p.left, q.left) && same(p.right, q.right);
            }
            return false;
        }
    }
}
