#include "common.h"
#include <queue>

using namespace std;

class Solution
{
public:
    bool isCousins(TreeNode *root, int x, int y, bool siblings = false, bool cousin = false)
    {
        using std::swap;
        queue<TreeNode *> q, q1;
        q.push(root);
        while (!q.empty() && !cousin)
        {
            while (!q.empty())
            {

                auto n = q.front();
                q.pop();
                if (!n)
                {
                    siblings = false;
                }
                else
                {
                    if (n->val == x || n->val == y)
                    {
                        if (!cousin)
                        {
                            cousin = siblings = true;
                        }
                        else
                        {
                            return !siblings;
                        }
                    }
                    q1.push(n->left), q1.push(n->right), q1.push(nullptr);
                }
            }
            swap(q, q1);
        }
        return false;
    }
};