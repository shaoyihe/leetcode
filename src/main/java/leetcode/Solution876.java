package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/middle-of-the-linked-list
 *  876. Middle of the Linked List
 * </pre>
 * on 2018/8/2.
 */
public class Solution876 {
    public static void main(String[] args) {
        Solution876 solution11 = new Solution876();
    }

    public ListNode middleNode(ListNode head) {
        //The number of nodes in the given list will be between 1 and 100
        ListNode[] total = new ListNode[100];
        int index;
        for (index = 0; head != null; head = head.next) {
            total[index++] = head;
        }
        return total[index / 2];
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
