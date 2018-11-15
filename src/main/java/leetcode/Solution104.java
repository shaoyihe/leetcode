package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *  104. Maximum Depth of Binary Tree
 * </pre>
 * on 2018/8/2.
 */
public class Solution104 {

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


    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

}
