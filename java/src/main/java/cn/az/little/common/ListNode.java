package cn.az.little.common;

import lombok.Data;

/**
 * @author : Liz
 * @date : 2019/10/20
 **/
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode that = this;
        while (that != null) {
            res.append(that.val).append(" -> ");
            that = that.next;
        }
        return res.toString();
    }
}
