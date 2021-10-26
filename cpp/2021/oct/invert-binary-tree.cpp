#include "common.h"

class Solution
{
public:
    TreeNode *invertTree(TreeNode *root)
    {
        using std::swap;
        if (root)
        {
            invertTree(root->left);
            invertTree(root->right);
            std::swap(root->left, root->right);
        }
        return root;
    }
};