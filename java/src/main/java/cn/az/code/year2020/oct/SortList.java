package cn.az.code.year2020.oct;

import cn.az.code.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author az
 * @since 10/13/20
 */
public class SortList {

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        System.out.println(sl.sortList(head));
    }

    // 1. brute force

    public ListNode sortList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        list.sort(Integer::compareTo);

        ListNode dummy = new ListNode(0);
        ListNode ret = dummy;
        for (int n : list) {
            dummy.next = new ListNode(n);
            dummy = dummy.next;
        }
        return ret.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return l.next;
    }


    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        int small = Integer.MAX_VALUE;
        ListNode cur = head;
        while (cur != null) {
            small = Math.min(small, cur.val);
            cur = cur.next;
        }

        return helper(head, small);
    }

    private ListNode helper(ListNode head, int small) {
        if (head == null) {
            return null;
        }
        int val = head.val;
        head.val = small;
        ListNode cur = head.next;

        int newSmall = val;
        while (cur != null) {
            if (small == cur.val) {
                cur.val = val;
            }
            newSmall = Math.min(newSmall, cur.val);
            cur = cur.next;
        }

        head.next = helper(head.next, newSmall);
        return head;
    }
}
