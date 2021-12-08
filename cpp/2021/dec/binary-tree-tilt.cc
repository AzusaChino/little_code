#include "common.h"

class Solution
{
public:
    int findTilt(TreeNode *root)
    {
        if (!root)
        {
            return 0;
        }
        int res = 0;
        post_order(root, res);

        return res;
    }

private:
    int post_order(TreeNode *root, int &res)
    {
        if (!root)
        {
            return 0;
        }

        int left_sum = post_order(root->left, res);

        int right_sum = post_order(root->right, res);

        res += abs(left_sum - right_sum);

        return left_sum + right_sum + root->val;
    }
};