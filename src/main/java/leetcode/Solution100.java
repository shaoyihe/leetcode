package leetcode;

import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/same-tree/
 *  100. Same Tree
 * </pre>
 * on 2018/8/2.
 */

public class Solution100 {

    @Test
    public void test() {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
