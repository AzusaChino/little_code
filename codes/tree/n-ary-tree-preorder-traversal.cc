#include <vector>

using namespace std;

class Node
{
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val)
    {
        val = _val;
    }

    Node(int _val, vector<Node *> _children)
    {
        val = _val;
        children = _children;
    }
};

class Solution
{
public:
    vector<int> preorder(Node *root)
    {
        vector<int> v;
        helper(&v, root);
        return v;
    }

    void helper(vector<int> *v, Node *node)
    {
        if (node)
        {
            for (auto n : node->children)
            {
                helper(v, n);
            }
            v->push_back(node->val);
        }
    }
};