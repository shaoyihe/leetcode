package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *  94. Binary Tree Inorder Traversal
 * </pre>
 * on 2018/8/2.
 */
public class Solution590 {

    @Test
    public void test() {
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root != null) {
            if (root.children != null) {
                for (Node node : root.children) {
                    postorder(node, result);
                }
            }
            result.add(root.val);
        }
    }

}
