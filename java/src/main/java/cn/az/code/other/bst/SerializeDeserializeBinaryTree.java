package cn.az.code.other.bst;

import cn.az.code.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * little-code
 *
 * @author azusachino
 * @since 24/9/2020 23:56
 */
public class SerializeDeserializeBinaryTree {

    private static final String NULL = "null";
    // Encodes a tree to a single string.
    /*
      序列化的思想是利用dfs的preorder遍历得到一个完整地序列，遇到null的地方可以直接存储null即可
      反序列化的思想是利用list这个结构，每次都返回list的首元素，作为上一个节点的左节点和右节点，然后依次删除掉list的首元素
    */

    public String serialize(TreeNode root) {
        return serializeHelper(root, "");
    }

    private String serializeHelper(TreeNode root, String str) {
        if (root == null) {
            str += NULL + ",";
            return str;
        }
        // preorder add node
        str += root.val + ",";
        str = serializeHelper(root.left, str);
        str = serializeHelper(root.right, str);

        return str;

    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        String[] dataList = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(dataList));
        return desHelper(list);
    }

    private TreeNode desHelper(List<String> list) {
        // empty tree or dfs end
        if (NULL.equals(list.get(0))) {
            list.remove(0);
            return null;
        }

        int val = Integer.parseInt(list.get(0));
        TreeNode root = new TreeNode(val);
        list.remove(0);

        root.left = desHelper(list);
        root.right = desHelper(list);

        return root;
    }
}
