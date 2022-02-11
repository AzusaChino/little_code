#include "math.h"
#include "common.h"

class Solution
{
private:
    ListNode *head;

public:
    Solution(ListNode *head)
    {
        this->head = head;
    }

    int getRandom()
    {
        int res = this->head->val;
        ListNode *node = this->head->next;
        int i = 2;
        while (node)
        {
            int j = rand() % i;
            if (j == 0)
            {
                res = node->val;
            }
            i++;
            node = node->next;
        }
        return res;
    }
};
