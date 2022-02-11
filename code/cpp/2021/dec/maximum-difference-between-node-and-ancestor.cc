#include "common.h"

class Solution
{
public:
    int maxAncestorDiff(TreeNode *root, int mn = 100000, int mx = 0)
    {
        return root ? max(maxAncestorDiff(root->left, min(mn, root->val), max(mx, root->val)),
                          maxAncestorDiff(root->right, min(mn, root->val), max(mx, root->val)))
                    : mx - mn;
    }
};