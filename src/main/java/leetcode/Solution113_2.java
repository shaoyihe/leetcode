package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/path-sum/description/
 *  113. Path Sum3
 * </pre>
 * on 2018/9/19.
 */
public class Solution113_2 extends BaseTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
//        TreeNode left = new TreeNode(4);
//        TreeNode right = new TreeNode(8);
//        root.left = left;
//        root.right = right;
        System.err.println(pathSum(root, 5));
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
        List<List<Integer>> result = iterPathSum(root, sum, 0);
        return result == null ? new ArrayList<>() : result;
    }

    private List<List<Integer>> iterPathSum(TreeNode root, int sum, int depth) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> result = new ArrayList<>(depth + 1);
                for (int i = 0; i < depth; ++i) result.add(0);
                result.add(depth, root.val);

                List<List<Integer>> finalResult = new ArrayList<>();
                finalResult.add(result);
                return finalResult;
            }
            return null;
        }

        List<List<Integer>> left = iterPathSum(root.left, sum - root.val, depth + 1);
        List<List<Integer>> right = iterPathSum(root.right, sum - root.val, depth + 1);

        if (left == null) left = right;
        else if (right != null) left.addAll(right);

        if (left != null) {
            for (List<Integer> temp : left) temp.set(depth, root.val);
        }
        return left;
    }


}
