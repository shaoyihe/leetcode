package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/path-sum/description/
 *  112. Path Sum
 * </pre>
 * on 2018/9/19.
 */
public class Solution113 extends BaseTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.left = left;
        root.right = right;
        System.err.println(pathSum(root, 9));
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


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = iterPathSum(root, sum);
        if (result != null) {
            for (List<Integer> temp : result) Collections.reverse(temp);
        }
        return result == null ? new ArrayList<>() : result;
    }

    private List<List<Integer>> iterPathSum(TreeNode root, int sum) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> result = new ArrayList<>();
                result.add(root.val);

                List<List<Integer>> finalResult = new ArrayList<>();
                finalResult.add(result);
                return finalResult;
            }
            return null;
        }

        List<List<Integer>> left = iterPathSum(root.left, sum - root.val);
        List<List<Integer>> right = iterPathSum(root.right, sum - root.val);

        if (left == null) left = right;
        else if (right != null) left.addAll(right);

        if (left != null) {
            for (List<Integer> temp : left) temp.add(root.val);
        }
        return left;
    }


}
