#include <stack>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    bool leafSimilar(TreeNode *root1, TreeNode *root2)
    {
        stack<TreeNode *> s1, s2;
        s1.push(root1);
        s2.push(root2);
        while (!s1.empty() && !s2.empty())
            if (dfs(s1) != dfs(s2))
                return false;
        return s1.empty() && s2.empty();
    }

    int dfs(stack<TreeNode *> &s)
    {
        while (true)
        {
            TreeNode *node = s.top();
            s.pop();
            if (node->right)
                s.push(node->right);
            if (node->left)
                s.push(node->left);
            if (!node->left && !node->right)
                return node->val;
        }
    }

    int pseudoPalindromicPaths(TreeNode *root, int count = 0)
    {
        if (!root)
            return 0;

        // track 1~9 count
        count ^= 1 << (root->val - 1);
        int res = this->pseudoPalindromicPaths(root->left, count) + this->pseudoPalindromicPaths(root->right, count);
        // at leaf, and only contains one odd (a &(a-1)) to check if a is pow of 2 (which is only one significant 1 in binary)
        if (root->left == root->right && (count & (count - 1)) == 0)
            res++;
        return res;
    }
};