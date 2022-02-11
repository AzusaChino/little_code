#include "common.h"

class Solution
{
public:
    int rot(TreeNode *root)
    {
        int l, r;
        return try_rob(root, l, r);
    }
    int try_rob(TreeNode *root, int &l, int &r)
    {
        if (!root)
        {
            return 0;
        }
        int ll = 0, lr = 0, rl = 0, rr = 0;
        l = try_rob(root->left, ll, lr);
        r = try_rob(root->right, rl, rr);
        return max(root->val + ll + lr + rl + rr, l + r);
    }
};