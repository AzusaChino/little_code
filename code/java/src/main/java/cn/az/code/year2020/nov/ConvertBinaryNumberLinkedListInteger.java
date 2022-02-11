package cn.az.code.year2020.nov;

import cn.az.code.common.ListNode;

/**
 * @author az
 * @since 11/01/20
 */
public class ConvertBinaryNumberLinkedListInteger {

    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
}
