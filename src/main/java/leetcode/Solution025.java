package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/palindrome-number
 * 9. Palindrome Number
 * </pre>
 * on 2018/8/2.
 */
public class Solution025 {
    public static void main(String[] args) {
        Solution025 solution020 = new Solution025();
//        System.err.println(solution020.isValid("([))")); //false
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }

    void loop(ListNode pre, ListNode next, int number, int[] n) {
        if (next != null) {
            n[0]++;
            loop(next, next.next, number + 1, n);
        }
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
