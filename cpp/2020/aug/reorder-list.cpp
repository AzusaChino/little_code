#include <common>

using namespace common

// O(N) time, O(1) space in total
void reorderList(ListNode *head) {
    if (!head || !head->next) return;

    // find the middle node: O(n)
    ListNode *p1 = head, *p2 = head->next;
    while (p2 && p2->next) {
        p1 = p1->next;
        p2 = p2->next->next;
    }

    // cut from the middle and reverse the second half: O(n)
    ListNode *head2 = p1->next;
    p1->next = NULL;

    p2 = head2->next;
    head2->next = NULL;
    while (p2) {
        p1 = p2->next;
        p2->next = head2;
        head2 = p2;
        p2 = p1;
    }

    // merge two lists: O(n)
    for (p1 = head, p2 = head2; p1;) {
        auto t = p1->next;
        p1 = p1->next = p2;
        p2 = t;
    }

    //for (p1 = head, p2 = head2; p2; ) {
    //    auto t = p1->next;
    //    p1->next = p2;
    //    p2 = p2->next;
    //    p1 = p1->next->next = t;
    //}
}

class Solution3 {
public:
    ListNode *reorderList(ListNode *head, int len) {
        if (len == 0)
            return NULL;
        if (len == 1)
            return head;
        if (len == 2)
            return head->next;
        ListNode *tail = reorderList(head->next, len - 2);
        ListNode *tmp = tail->next;  
        tail->next = tail->next->next;
        tmp->next = head->next;
        head->next = tmp;
        return tail;
    }

    void reorderList(ListNode *head) {  //recursive
        ListNode *tail = NULL;
        tail = reorderList(head, getLength(head));
    }
};