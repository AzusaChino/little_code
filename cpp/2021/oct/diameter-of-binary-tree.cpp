#include "common.h"

class Solution
{
public:
    // find max depth in both left and right tree
    int diameterOfBinaryTree(TreeNode *root)
    {
        int depth = 0;
        helper(root, depth);
        return depth;
    }
    int helper(TreeNode *node, int &depth)
    {
        if (!node)
        {
            return 0;
        }
        int ld = helper(node->left, depth);
        int rd = helper(node->right, depth);
        depth = max(depth, ld + rd);
        return max(ld, rd) + 1;
    }
};