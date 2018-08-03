package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 *  https://leetcode.com/problems/merge-k-sorted-lists/description/
 *  24. Swap Nodes in Pairs
 * </pre>
 * on 2018/8/2.
 */
public class Solution024 {
    public static void main(String[] args) {
        Solution024 solution11 = new Solution024();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);

        System.err.println(solution11.swapPairs(first));
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;

        if (head.next != null && head.next.next != null) {
            for (ListNode pre = head, next = pre.next, nextNext = next.next; ; ) {
                pre.next = nextNext;
                next.next = nextNext.next;
                nextNext.next = next;

                nextNext = next;
                if (nextNext.next != null && nextNext.next.next != null) {
                    pre = nextNext;
                    next = nextNext.next;
                    nextNext = nextNext.next.next;
                } else {
                    break;
                }
            }
        }
        return newHead;
    }

}
