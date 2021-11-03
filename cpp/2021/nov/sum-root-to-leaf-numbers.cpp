#include <numeric>
#include <vector>

#include "common.h"

using namespace std;

class Solution
{
public:
    int sumNumbers(TreeNode *root)
    {
        vector<int> v;
        int cur = 0;
        helper(root, cur, &v);
        return accumulate(v.begin(), v.end(), 0);
    }

private:
    void helper(TreeNode *node, int cur, vector<int> *v)
    {
        if (!node)
        {
            return;
        }
        cur = cur * 10 + node->val;
        if (!node->left && !node->right)
        {
            v->push_back(cur);
        }
        if (node->left)
        {
            helper(node->left, cur, v);
        }
        if (node->right)
        {
            helper(node->right, cur, v);
        }
    }
};