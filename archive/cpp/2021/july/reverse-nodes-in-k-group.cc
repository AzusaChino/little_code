#include <stack>

#include "common.h"

using namespace std;

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        stack<ListNode*> s;
        ListNode*        curr = head;
        ListNode*        prev = NULL;
        ListNode*        temp = head;

        while (curr != NULL) {
            int cnt = 1, cnt1 = 1;
            while (curr != NULL and cnt <= k) {
                s.push(curr);
                cnt++;
                curr = curr->next;
            }

            // now my stack has all the k values in it
            // just pop out stack and our k-Group is reversed since stack is
            // LIFO
            if (cnt != k + 1) {
                while (temp != NULL) {
                    prev->next = temp;
                    prev       = prev->next;
                    temp       = temp->next;
                }
                break;
            }
            while (temp != NULL and cnt1 <= k) {
                cnt1++;
                temp = temp->next;
            }
            while (!s.empty()) {
                if (prev == NULL) {
                    prev = s.top();
                    s.pop();
                    head = prev;
                } else {
                    prev->next = s.top();
                    s.pop();
                    prev = prev->next;
                }
            }
        }
        prev->next = NULL;
        return head;
    }
};
