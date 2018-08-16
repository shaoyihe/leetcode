package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/linked-list-cycle/description/
 * 141. Linked List Cycle
 * </pre>
 * on 2018/8/13.
 */
public class Solution141 {

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        Assert.assertFalse(hasCycle(first));

        first.next.next.next.next = first;
        Assert.assertTrue(hasCycle(first));

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        return hasCycle(head, head.next.next);
    }

    private boolean hasCycle(ListNode first, ListNode sec) {
        if (sec == null || sec.next == null) return false;
        if (first == sec) return true;
        return hasCycle(first.next, sec.next.next);
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
