package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *  145. Binary Tree Postorder Traversal
 * </pre>
 * on 2018/8/2.
 */
public class Solution145 {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (TreeNode last = null; !stack.isEmpty(); ) {
            TreeNode peek = stack.peek();
            if (peek.right != null) {
                if (last != null && last == peek.right) {
                    //pop peek
                    last = stack.pop();
                    result.add(last.val);
                    continue;
                }
            }

            if (peek.left != null) {
                if (last != null && last == peek.left) {
                    //pop peek

                } else {
                    stack.push(peek.left);
                    continue;
                }
            }

            if (peek.right != null) {
                stack.push(peek.right);
                continue;
            }

            //end condition pop peek
            last = stack.pop();
            result.add(last.val);
        }

        return result;
    }

}
