package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *  95. Unique Binary Search Trees II
 * </pre>
 * on 2018/8/2.
 */

public class Solution095 {

    @Test
    public void test() {
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int from, int to) {
        if (from > to) return Collections.emptyList();

        int total = 0;
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = from; i <= to; ++i) {
            List<TreeNode> leftTreeNodes = generateTrees(from, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, to);
            if (leftTreeNodes.isEmpty()) {
                for (TreeNode treeNode : rightNodes) {
                    TreeNode returnTreeNode = new TreeNode(i);
                    returnTreeNode.right = treeNode;
                    treeNodes.add(returnTreeNode);
                }
            } else if (rightNodes.isEmpty()) {
                for (TreeNode treeNode : leftTreeNodes) {
                    TreeNode returnTreeNode = new TreeNode(i);
                    returnTreeNode.left = treeNode;
                    treeNodes.add(returnTreeNode);
                }
            } else {
                for (TreeNode rightNode : rightNodes) {
                    for (TreeNode leftNode : leftTreeNodes) {
                        TreeNode returnTreeNode = new TreeNode(i);
                        returnTreeNode.left = leftNode;
                        returnTreeNode.right = rightNode;
                        treeNodes.add(returnTreeNode);
                    }
                }
            }
        }
        if (treeNodes.isEmpty()) treeNodes.add(new TreeNode(from));
        return treeNodes;
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
