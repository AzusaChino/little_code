package medium

import . "common"

func Rotate(head *ListNode, k int) *ListNode {
    if head == nil {
        return nil
    }
    copyHead := head

    length := 1

    for copyHead.Next != nil {
        length++
        copyHead = copyHead.Next
    }
    copyHead.Next = head

    for i := length - k % length; i > 1; i-- {
        head = head.Next
    }
    copyHead = head.Next
    head.Next = nil
    return copyHead
}
