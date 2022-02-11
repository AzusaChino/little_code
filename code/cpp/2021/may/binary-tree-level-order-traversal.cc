#include <queue>
#include <vector>

#include "common.h"

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (!root) {
            return result;
        }
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            vector<int> cur_level;
            auto        sz = q.size();
            for (decltype(sz) i = 0; i < sz; ++i) {
                TreeNode* node = q.front();
                q.pop();
                cur_level.push_back(node->val);
                if (node->left) {
                    q.push(node->left);
                }
                if (node->right) {
                    q.push(node->right);
                }
            }
            result.push_back(cur_level);
        }
        return result;
    }
};