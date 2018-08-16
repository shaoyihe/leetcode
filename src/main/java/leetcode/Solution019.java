package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *  19. Remove Nth Node From End of List
 * </pre>
 * on 2018/8/2.
 */
public class Solution019 {
    public static void main(String[] args) {
        Solution019 solution11 = new Solution019();

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        System.err.println(solution11.removeNthFromEnd(first, 4));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int[] totalLength = {0};
        loop(head, head.next, 1, n, totalLength);
        if (totalLength[0] == n) return head.next;
        return head;
    }

    private void loop(ListNode cur, ListNode next, int pos, int n, int[] total) {
        total[0]++;
        if (next != null) {
            loop(next, next.next, pos + 1, n, total);
            if (n == total[0] - pos) {
                cur.next = next.next;
            }
        }
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
