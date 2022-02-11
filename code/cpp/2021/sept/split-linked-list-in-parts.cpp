#include <vector>
#include "common.h"

using namespace std;

class Solution
{
public:
    vector<ListNode *> splitListToParts(ListNode *head, int k)
    {
        vector<ListNode *> parts(k, nullptr);
        int len = 0;
        for (auto node = head; node; node = node->next)
        {
            len++;
        }
        int n = len / k, r = len % k;
        ListNode *node = head, *prev = nullptr;
        for (int i = 0; node && i < k; i++, r--)
        {
            parts[i] = node;
            for (int j = 0; j < n + (r > 0); j++)
            {
                prev = node;
                node = node->next;
            }
            prev->next = nullptr;
        }
        return parts;
    }
};