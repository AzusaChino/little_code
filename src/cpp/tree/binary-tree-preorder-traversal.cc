#include <structs.h>

#include <vector>

using namespace std;

class Solution
{
public:
    vector<int> preorderTraversal(TreeNode *root)
    {
        vector<int> v{};
        this->do_traversal(root, &v);
        return v;
    }

private:
    void do_traversal(TreeNode *root, vector<int> *v)
    {
        if (!root)
        {
            return;
        }
        v->push_back(root->val);
        this->do_traversal(root->left, v);
        this->do_traversal(root->right, v);
    }
};