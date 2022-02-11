package cn.az.code.common;

/**
 * @author Liz
 * @since 2019/11/6
 **/
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public static TreeNode of(int _val) {
        return new TreeNode(_val);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        TreeNode treeNode = (TreeNode) o;
//        return val == treeNode.val &&
//                Objects.equal(left, treeNode.left) &&
//                Objects.equal(right, treeNode.right);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(val, left, right);
//    }
}
