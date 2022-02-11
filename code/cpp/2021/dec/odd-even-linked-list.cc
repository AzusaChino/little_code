#include "common.h"

class Solution
{
public:
    ListNode *oddEvenList(ListNode *head)
    {
        if (!head)
        {
            return head;
        }
        ListNode *odd = head, *even_head = head->next, *even = even_head;

        while (even && even->next)
        {
            odd->next = odd->next->next;
            even->next = even->next->next;
            odd = odd->next;
            even = even->next;
        }
        odd->next = even_head;
        return head;
    }
};