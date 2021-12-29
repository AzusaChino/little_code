#include "node.h"

class Solution
{
public:
    Node *connect(Node *root)
    {
        if (!root)
        {
            return root;
        }
        Node *pre = root;
        Node *cur = nullptr;

        while (pre->left)
        {
            cur = pre;
            while (cur)
            {
                cur->left->next = cur->right;
                if (cur->next)
                {
                    cur->right->next = cur->next->left;
                }
                // will break if root
                cur = cur->next;
            }
            pre = pre->left;
        }
        return root;
    }
};