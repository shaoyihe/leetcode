package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 143. Reorder List
 * </pre>
 * on 2018/8/13.
 */
public class Solution143 {

    @Test
    public void test() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
//        first.next.next.next.next = new ListNode(5);
        reorderList(first);
        System.err.println(first);
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

    private ListNode head;
    private ListNode headNext;
    private boolean end = false;

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        this.head = head;
        this.headNext = head.next;
        reorderList(head.next, head);
    }

    private void reorderList(ListNode last, ListNode beforeLast) {
        if (last != null) {
            reorderList(last.next, last);
            if (end) return;

            if (this.head != beforeLast && this.head != last) {
                this.head.next = last;
                beforeLast.next = null;
                last.next = this.headNext;

                //advance
                this.head = this.headNext;
                this.headNext = this.head == null ? null : this.head.next;
            } else {
                end = true;
            }
        }
    }
}
