#include "common.h"

class Solution
{
public:
    int getDecimalValue(ListNode *head)
    {
        int r = 0;
        while (head)
        {
            r <<= 1;
            r |= head->val;
            head = head->next;
        }
        return r;
    }
};