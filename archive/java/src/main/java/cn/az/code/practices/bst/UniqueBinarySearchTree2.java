package cn.az.code.practices.bst;

import cn.az.code.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author az
 * @since 09/15/20
 */
public class UniqueBinarySearchTree2 {

    public List<TreeNode> generateTree(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

        return dfs(1, n);
    }

    /**
     * n 作为根节点，[ 1... n-1 ] 的所有可能作为左子树，[ ] 作为右子树。
     *
     * @param start s
     * @param end   e
     * @return list
     */
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        // 此时没有数字，将 null 加入结果中
        if (start > end) {
            ret.add(null);
            return ret;
        }
        for (int rootValue = start; rootValue <= end; rootValue++) {
            // 得到所有可能的左子树
            List<TreeNode> leftTreeNodes = dfs(start, rootValue - 1);
            // 得到所有可能的右子树
            List<TreeNode> rightTreeNodes = dfs(rootValue + 1, end);
            // 左子树右子树两两组合
            for (TreeNode leftTree : leftTreeNodes) {
                for (TreeNode rightTree : rightTreeNodes) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];

        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int rootIndex = 1; rootIndex <= i; rootIndex++) {
                int left = rootIndex - 1;
                int right = i - rootIndex;
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode root = new TreeNode(rootIndex);
                        root.left = leftTree;
                        root.right = clone(rightTree, rootIndex);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }

    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null) {
                            break;
                        }
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null) {
                        break;
                    }
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
    }

    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }

    public TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode root = new TreeNode(node.val + offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
}
