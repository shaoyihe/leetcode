package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *  104. Maximum Depth of Binary Tree
 * </pre>
 * on 2018/8/2.
 */
public class Solution111 {

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


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int[] minDepth = new int[]{-1};
        minDepth(root, 1, minDepth);
        return minDepth[0];
    }

    private void minDepth(TreeNode root, int depth, int[] minDepth) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (minDepth[0] == -1 || depth < minDepth[0]) minDepth[0] = depth;
            return;
        }
        minDepth(root.left, depth + 1, minDepth);
        minDepth(root.right, depth + 1, minDepth);
    }

}
