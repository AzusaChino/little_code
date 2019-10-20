from python.common.ListNode import ListNode


def add_two(l1, l2):
    if l1 is None:
        return l2
    elif l2 is None:
        return l1
    else:
        carry = 0
        result = ListNode(0)
        temp = result

        while l1 or l2:
            sum_total = 0
            if l1:
                sum_total = l1.val
                l1 = l1.next
            if l2:
                sum_total += l2.val
                l2 = l2.next
            sum_total += carry
            temp.next = ListNode(sum_total % 10)
            temp = temp.next
            carry = (sum_total >= 10)
        if carry:
            temp.next = ListNode(1)
        temp = result.next
        del result
        return temp
