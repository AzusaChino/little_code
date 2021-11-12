#include "common.h"

class Solution
{
public:
    ListNode *removeElements(ListNode *head, int val)
    {
        if (head == nullptr)
        {
            return nullptr;
        }
        ListNode *next = removeElements(head->next, val);
        if (head->val == val)
        {
            return next;
        }
        head->next = next;
        return head;
    }
};
