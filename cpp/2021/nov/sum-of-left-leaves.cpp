#include "common.h"

class Solution
{
public:
    int sumOfLeftLeaves(TreeNode *root)
    {
        if (!root)
        {
            return 0;
        }
        int l = 0, r = 0;
        if (root->left)
        {
            if (!root->left->left && !root->left->right)
            {
                l = root->left->val;
            }
            else
            {
                l = sumOfLeftLeaves(root->left);
            }
        }
        if (root->right)
        {
            r = sumOfLeftLeaves(root->right);
        }
        return l + r;
    }
};