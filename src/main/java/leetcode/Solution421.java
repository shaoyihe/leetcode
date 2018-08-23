package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *  421. Maximum XOR of Two Numbers in an Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution421 extends BaseTest {

    @Test
    public void test() {
        assertEquals(28, findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));

        assertEquals(28, findMaximumXOR2(new int[]{3, 10, 5, 25, 2, 8}));
        assertEquals(10, findMaximumXOR2(new int[]{8, 10, 2}));
        assertEquals(0, findMaximumXOR2(new int[]{1}));
        assertEquals(62, findMaximumXOR2(new int[]{32, 18, 33, 42, 29, 20, 26, 36, 15, 46}));
        assertEquals(127, findMaximumXOR2(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}));
    }

    /**
     * error
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        // find maxVal
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > maxVal) maxVal = nums[i];
        }

        int maxXor = 0;
        for (int num : nums) {
            if ((maxVal ^ num) > maxXor) maxXor = maxVal ^ num;
        }
        return maxXor;
    }


    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public int findMaximumXOR2(int[] nums) {
        // find maxVal
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > maxVal) maxVal = nums[i];
        }

        Node root = new Node(0);
        int[] numBits = new int[31];
        int maxBit = recordNode(numBits, root, -1, maxVal);
        for (int num : nums) {
            recordNode(numBits, root, maxBit, num);
        }
        Arrays.fill(numBits, 0);
        int[] max = new int[1];
        findMaxVal(numBits, 0, maxBit, root.left, root.right, false, max);
        return max[0];
    }

    private int recordNode(int[] numBits, Node root, int maxBit, int num) {
        int curIndex = 0;
        for (; num > 0; num >>= 1) {
            numBits[curIndex++] = num & 1;
        }
        --curIndex;
        if (curIndex > maxBit) maxBit = curIndex;

        Node curNode = root;
        for (int i = maxBit; i >= 0; --i) {
            int numBit = i > curIndex ? 0 : numBits[i];

            if (curNode.left == null) {
                curNode.left = new Node(numBit);
            } else if (curNode.left.val != numBit && curNode.right == null) {
                curNode.right = new Node(numBit);
            }
            curNode = curNode.left.val == numBit ? curNode.left : curNode.right;
        }
        return maxBit;
    }

    private void findMaxVal(int[] numBits, int index, int maxBit, Node left, Node right, boolean reset, int[] max) {
        if (index == maxBit) {
//            last
            if (left != null && right != null) {
                int target = left.val ^ right.val;
                if (reset || target == 1) numBits[index] = target;
            } else if (reset) {
                numBits[index] = 0;
            }

            // find max
            int result = 0;
            for (int i = 0; i <= maxBit; ++i) {
                if (numBits[i] == 1) result |= 1 << (maxBit - i);
            }
            if (result > max[0]) max[0] = result;
        } else if (index < maxBit) {
            if (left == null || right == null) {
                Node cur = left == null ? right : left;

                if (reset || numBits[index] == 0) {
                    numBits[index] = 0;
                    findMaxVal(numBits, index + 1, maxBit, cur.left, cur.right, reset, max);
                }
                return;
            }

            boolean needRest = false;
            int curVal = left.val ^ right.val;
            int oldNum = numBits[index];
            if (reset || curVal > numBits[index]) {
                needRest = curVal > numBits[index];
                numBits[index] = curVal;
            }

            boolean subHas1 = left.right != null || right.right != null || (left.left.val ^ right.left.val) == 1;

            if (subHas1) {
                if (left.left.val == 0) {
                    Node target = right.left.val == 1 ? right.left : right.right;

                    if (target != null)
                        findMaxVal(numBits, index + 1, maxBit, left.left, target, reset || needRest, max);

                    if (left.right != null) {
                        target = right.right;
                        if (right.left.val == 0) {
                            target = right.left;
                        }
                        if (target != null) {
                            findMaxVal(numBits, index + 1, maxBit, left.right, target, reset || needRest, max);
                        }
                    }

                } else {
                    Node target = right.left.val == 0 ? right.left : right.right;

                    if (target != null)
                        findMaxVal(numBits, index + 1, maxBit, left.left, target, reset || needRest, max);

                    if (left.right != null) {
                        target = right.right;
                        if (right.left.val == 1) {
                            target = right.left;
                        }

                        if (target != null) {
                            findMaxVal(numBits, index + 1, maxBit, left.right, target, reset || needRest, max);
                        }
                    }
                }
            } else {
                if (reset || (oldNum == 0 && numBits[index + 1] == 0)) {
                    findMaxVal(numBits, index + 1, maxBit, left.left, right.left, reset, max);
                }
            }
        }
    }

}
