#include "common.h"

class Solution
{
public:
    ListNode *sortList(ListNode *head)
    {
        bool done = (!head);
        // Keep partitioning our list into bigger sublists length. Starting with a size of 1 and doubling each time
        for (int step = 1; !done; step *= 2)
        {
            done = true;
            ListNode **next_ptr = &head;
            ListNode *remaining = head;
            ListNode *list[2];
            do
            {
                // Split off two sublists of size step
                for (auto &sub_head : list)
                {
                    sub_head = remaining;
                    ListNode *tail = nullptr;
                    for (int i = 0; i < step && remaining; ++i, remaining = remaining->next)
                    {
                        tail = remaining;
                    }
                    // Terminate our sublist
                    if (tail)
                    {
                        tail->next = nullptr;
                    }
                }

                // We're done if these are the first two sublists in this pass and they
                // encompass the entire primary list
                done &= !remaining;

                // If we have two sublists, merge them into one
                if (list[1])
                {
                    while (list[0] || list[1])
                    {
                        int idx = (!list[1] || list[0] && list[0]->val <= list[1]->val) ? 0 : 1;
                        *next_ptr = list[idx];
                        list[idx] = list[idx]->next;
                        next_ptr = &(**next_ptr).next;
                    }

                    // Terminate our new sublist
                    *next_ptr = nullptr;
                }
                else
                {
                    // Only a single sublist, no need to merge, just attach to the end
                    *next_ptr = list[0];
                }
            } while (remaining);
        }
        return head;
    }

    ListNode *sortList_(ListNode *head, ListNode *tail = nullptr)
    {
        if (head != tail)
        {
            // Use head node as the pivot node
            // Everything in the _smaller_ list will be less than _head_
            // and everything appearing after _head_ in the list is greater or equal
            ListNode *smaller;
            ListNode **smaller_next = &smaller;
            for (ListNode **prev = &head->next; *prev != tail;)
            {
                if (head->val > (**prev).val)
                {
                    *smaller_next = *prev;
                    smaller_next = &((**smaller_next).next);

                    // Remove smaller node from original list
                    *prev = (**prev).next;
                }
                else
                {
                    // Correct position, skip over
                    prev = &((**prev).next);
                }
            }

            // Connect the end of smaller list to the head (which is the partition node)
            // We now have. [smaller list...] -> head -> [larger list]
            *smaller_next = head;

            // Continue to sort everything after head
            head->next = sortList_(head->next, tail);

            // Sort everything upto head
            head = sortList_(smaller, head);
        }
        return head;
    }

private:
    int lengthOfList(ListNode *head)
    {
        int cnt = 0;
        ListNode *copy = head;
        while (copy)
        {
            cnt++;
            copy = copy->next;
        }
        return cnt;
    }
    ListNode *findSmallest(ListNode *head)
    {
        ListNode *copy = head, *smallest = head;
        while (copy && copy->next)
        {
            if (smallest->val < copy->next->val)
            {
                smallest = copy->next;
            }
            copy = copy->next;
        }
        return smallest;
    }
};