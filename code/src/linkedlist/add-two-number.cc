#include "common.h"

class Solution
{
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {
        int carry = 0;

        ListNode newHead(0);
        ListNode *t = &newHead;

        while (carry || l1 || l2)
        {
            carry += (l1 ? l1->val : 0) + (l2 ? l2->val : 0);
            // 取余
            t->next = new ListNode(carry % 10);
            t = t->next;
            carry /= 10;
            if (l1)
            {
                l1 = l1->next;
            }
            if (l2)
            {
                l2 = l2->next;
            }
        }
        return newHead.next;
    }
};