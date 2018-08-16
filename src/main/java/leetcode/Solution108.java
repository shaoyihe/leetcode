package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 108. Convert Sorted Array to Binary Search Tree
 * </pre>
 * on 2018/8/13.
 */
public class Solution108 {

    @Test
    public void test() {
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if (from > to) return null;
        if (from == to) return new TreeNode(nums[from]);

        int middle = (from + to) / 2;
        TreeNode cur = new TreeNode(nums[middle]);
        cur.left = sortedArrayToBST(nums, from, middle - 1);
        cur.right = sortedArrayToBST(nums, middle + 1, to);
        return cur;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
