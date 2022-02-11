#include "common.h"

class Solution
{
public:
    TreeNode *deleteNode(TreeNode *root, int key)
    {
        if (!root)
        {
            return nullptr;
        }
        if (key < root->val)
        {
            root->left = deleteNode(root->left, key);
        }
        else if (key > root->val)
        {
            root->right = deleteNode(root->right, key);
        }
        else
        {
            if (!root->left)
            {
                return root->right;
            }
            else if (!root->right)
            {
                return root->left;
            }
            else
            {
                auto minNode = findMin(root->right);
                root->val = minNode->val;
                root->right = deleteNode(root->right, root->val);
            }
            return root;
        }
    }

private:
    TreeNode *findMin(TreeNode *root)
    {
        while (root->left)
        {
            root = root->left;
        }
        return root;
    }
};