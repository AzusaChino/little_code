#include "common.h"

class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        ListNode *ans;
        ListNode *slow = head; //t1
        ListNode *fast = head; //t2

        for (int i = 0; i < n; ++i)
        {
            fast = fast->next;
        }

        if (fast == nullptr)
        {
            ans = head->next;
            delete head;
            return ans;
        }

        while (fast->next != nullptr)
        {
            fast = fast->next;
            slow = slow->next;
        }
        delete slow->next;
        slow->next = slow->next->next;

        return head;
    }
};