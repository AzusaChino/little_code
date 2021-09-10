#include "common.h"

TreeNode *deleteNode(TreeNode *root, int key) {
    if (root) {
        if (root->val < key) root->right = deleteNode(root->right, key);
        else if (root->val > key) root->left = deleteNode(root->left, key);
        else {
            if (root->left && root->right) {
                int min = getMin(root->right);
                root->val = min;
                root->right = deleteNode(root->right, min);
            } else {
                TreeNode *to_delete = root;
                if (root->left) root = root->left;
                else if (root->right) root = root->right;
                else root = NULL;
                delete to_delete;
            }
        }
    }
    return root;
}

int getMin(TreeNode *root) {
    while (root->left) root = root->left;
    return root->val;
}
