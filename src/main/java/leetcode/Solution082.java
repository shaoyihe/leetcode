package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *  83. Remove Duplicates from Sorted List
 * </pre>
 * on 2018/8/2.
 */

public class Solution082 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        deleteDuplicates(listNode);
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        if (head.next.val != head.val) newHead = head;
        ListNode iterHead = newHead;
        for (ListNode pre = head, cur = head.next; cur != null; pre = cur, cur = cur.next) {
            if (cur.val != pre.val && (cur.next == null || cur.next.val != cur.val)) {
                if (newHead == null) iterHead = newHead = cur;
                else iterHead = iterHead.next = cur;
            }
        }
        if (iterHead != null) iterHead.next = null;
        return newHead;
    }

}
