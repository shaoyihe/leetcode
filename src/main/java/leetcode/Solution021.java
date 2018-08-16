package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/merge-two-sorted-lists/description/
 *  21. Merge Two Sorted Lists
 * </pre>
 * on 2018/8/2.
 */
public class Solution021 {
    public static void main(String[] args) {
        Solution021 solution11 = new Solution021();

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        System.err.println(solution11.mergeTwoLists(first, first));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, pre = null;
        for (; ; ) {
            if (l1 == null) {
                if (head == null) {
                    head = pre = l2;
                } else {
                    pre.next = l2;
                }
                break;
            } else if (l2 == null) {
                if (head == null) {
                    head = pre = l1;
                } else {
                    pre.next = l1;
                }
                break;
            } else {
                ListNode curNode;
                if (l1.val <= l2.val) {
                    curNode = l1;
                    l1 = l1.next;
                } else {
                    curNode = l2;
                    l2 = l2.next;
                }
                if (head == null) {
                    head = pre = curNode;
                } else {
                    pre = pre.next = curNode;
                }
            }
        }
        return head;
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

}
