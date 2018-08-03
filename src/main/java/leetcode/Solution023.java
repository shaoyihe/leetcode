package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 *  https://leetcode.com/problems/merge-k-sorted-lists/description/
 *  23. Merge k Sorted Lists
 * </pre>
 * on 2018/8/2.
 */
public class Solution023 {
    public static void main(String[] args) {
        Solution023 solution11 = new Solution023();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);

        ListNode second = new ListNode(1);
        second.next = new ListNode(2);
        second.next.next = new ListNode(3);
        second.next.next.next = new ListNode(4);
        System.err.println(solution11.mergeKLists2(new ListNode[]{first, second}));
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = null, pre = null;
        for (; ; ) {
            int minListIndex = -1;
            int notNullCount = 0;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null) {
                    notNullCount++;
                    if (minListIndex == -1 || lists[i].val < lists[minListIndex].val) {
                        minListIndex = i;
                    }
                }
            }
            if (minListIndex == -1) break;

            if (head == null) {
                head = pre = lists[minListIndex];
            } else {
                pre = pre.next = lists[minListIndex];
            }
            lists[minListIndex] = lists[minListIndex].next;

            if (notNullCount == 1) {
                pre.next = lists[minListIndex];
                break;
            }
        }
        return head;
    }

    /**
     * 最小堆实现
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : lists) {
            if (listNode != null) listNodes.add(listNode);
        }
        if (listNodes.isEmpty()) return null;

        ListNode head = null, pre = null;
        for (; ; ) {
            ListNode curNode = listNodes.poll();

            if (head == null) {
                head = pre = curNode;
            } else {
                pre = pre.next = curNode;
            }
            curNode = curNode.next;

            if (listNodes.isEmpty()) {
                pre.next = curNode;
                break;
            } else if (curNode != null) {
                listNodes.add(curNode);
            }
        }
        return head;
    }

}
