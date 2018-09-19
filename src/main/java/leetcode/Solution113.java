package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
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


//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//
//    }
//
//    private List<Integer> iterPathSum(TreeNode root, int sum) {
//        if (root == null) return null;
//        if (root.left == null && root.right == null) {
//            if (sum == root.val) {
//                List<Integer> result = new ArrayList<>();
//                result.add(root.val);
//                return result;
//            }
//            return null;
//        }
//        List<Integer> result = iterPathSum(root.left, sum - root.val);
//        if (result != null) {
//            result.add()
//        }
//        iterPathSum(root.right, sum - root.val);
//    }


}
