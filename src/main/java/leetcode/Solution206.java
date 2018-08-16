package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-linked-list/description/
 *  206. Reverse Linked List
 * </pre>
 * on 2018/8/2.
 */

public class Solution206 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        reverseList(listNode);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode newHead = null;
        for (ListNode cur = head, next; cur != null; cur = next) {
            next = cur.next;
            if (newHead == null) {
                newHead = cur;
                newHead.next = null;
            } else {
                cur.next = newHead;
                newHead = cur;
            }
        }

        return newHead;
    }

    /**
     * Definition for singly-linked list.
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
