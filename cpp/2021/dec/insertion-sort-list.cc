#include "common.h"

class Solution
{
public:
    ListNode *insertionSortList(ListNode *head)
    {
        ListNode *dummy = new ListNode(0);
        dummy->next = head;

        ListNode *pre = dummy, *cur = head;

        while (cur)
        {
            if ((cur->next) && (cur->next->val < cur->val))
            {
                while ((pre->next) && (pre->next->val < cur->next->val))
                {
                    pre = pre->next;
                }
                ListNode *tmp = pre->next;
                pre->next = cur->next;
                cur->next = cur->next->next;
                pre->next->next = tmp;
                pre = dummy;
            }
            else
            {
                cur = cur->next;
            }
        }
        return dummy->next;
    }
};