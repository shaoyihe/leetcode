package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-linked-list-ii/
 *  92. Reverse Linked List II
 * </pre>
 * on 2018/8/2.
 */

public class Solution092 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        reverseBetween(listNode, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) return head;

        ListNode newHead = null;
        int count = 1;
        for (ListNode cur = head, next = null, segHead = null, lastNode = null; cur != null; ++count, cur = next) {
            next = cur.next;

            if (count > n) {
                lastNode.next = cur;
                break;
            }
            if (count >= m) {
                if (newHead == null) {
                    lastNode = newHead = cur;
                    newHead.next = null;
                } else {
                    if (count == m) {
                        segHead.next = null;
                        lastNode = cur;
                    }
                    //begin reverse
                    if (segHead == null) {
                        cur.next = newHead;
                        newHead = cur;
                    } else {
                        cur.next = segHead.next;
                        segHead.next = cur;
                    }
                }
            } else {
                if (newHead == null) {
                    newHead = cur;
                }
                segHead = cur;
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
