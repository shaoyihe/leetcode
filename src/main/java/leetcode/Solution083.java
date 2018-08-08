package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *  83. Remove Duplicates from Sorted List
 * </pre>
 * on 2018/8/2.
 */

public class Solution083 {

    @Test
    public void test() {
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
        for (ListNode cur = head, pre = head; cur != null; ) {
            for (; cur.next != null && cur.next.val == pre.val; cur = cur.next) ;
            pre = cur = pre.next = cur.next;
        }
        return head;
    }

}
