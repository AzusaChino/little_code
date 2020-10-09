class RotateList {
public:
    ListNode *rotate(ListNode *head, int k) {
        if (!head) {
            return head;
        }
        int len = 1;
        ListNode *newHead, *tail;
        newHead = tail = head;
        while (tail->next) {
            tail = tail->next;
            len++;
        }
        // make a circle
        tail->next = head;
        // check if 0
        if (k %= len) {
            for (auto i = 0; i < len - k; i++) {
                tail = tail->next;
            }
        }
        newHead = tail->next;
        tail->next = NULL;
        return newHead;
    }
};