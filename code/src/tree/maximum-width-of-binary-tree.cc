#include "algorithm"
#include "common.h"

class Solution
{
public:
    int widthOfBinaryTree(TreeNode *root)
    {
        return dfs(root, 0, 1, vector<pair<int, int>>() = {});
    }

private:
    int dfs(TreeNode *root, int level, int order, vector<pair<int, int>> &vec)
    {
        if (!root)
        {
            return 0;
        }
        if (vec.size() == level)
        {
            vec.push_back({order, order});
        }
        else
        {
            vec[level].second = order;
        }
        return max({vec[level].second - vec[level].first + 1, dfs(root->left, level + 1, 2 * order, vec), dfs(root->right, level + 1, 2 * order + 1, vec)});
    }
};