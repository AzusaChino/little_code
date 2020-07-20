from common import ListNode


class Solution:
    def addTwoNumbers(self, l1, l2):
        def to_int(node):
            return node.val + 10 * to_int(node.next) if node else 0

        def to_list(n):
            node = ListNode(n % 10)
            if n > 9:
                node.next = to_list(n / 10)
            return node

        return to_list(to_int(l1) + to_int(l2))

    def _addTwoNumbers(self, l1, l2):
        addends = l1, l2
        dummy = end = ListNode(0)
        carry = 0
        while addends or carry:
            carry += sum(a.val for a in addends)
            addends = [a.next for a in addends if a.next]
            end.next = end = ListNode(carry % 10)
            carry /= 10
        return dummy.next
