#include "common.h"

using namespace std;

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* cur = root;
        while (true) {
            if (p->val < cur->val && q->val < cur->val) {
                cur = cur->left;
            } else if (p->val > cur->val && q->val > cur->val) {
                cur = cur->right;
            } else {
                break;
            }
        }
        return cur;
    }
};
