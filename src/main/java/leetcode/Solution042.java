package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * <pre>
 *  https://leetcode.com/problems/trapping-rain-water/description/
 *  42. Trapping Rain Water
 * </pre>
 * on 2018/8/2.
 */

public class Solution042 {

    @Test
    public void test() {
        Assert.assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        Assert.assertEquals(6, trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private Count count(int val) {
        Count count = new Count();
        count.val = val;
        return count;
    }

    private Count count(int val, int times) {
        Count count = count(val);
        count.times = times;
        return count;
    }

    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) return 0;

        int totalLength = 0;
        Stack<Count> stack = new Stack<>();
        stack.push(count(heights[0]));
        for (int i = 1; i < heights.length; ++i) {
            Count peek = stack.peek();
            if (peek.val == heights[i]) {
                peek.times++;
            } else if (peek.val > heights[i]) {
                stack.push(count(heights[i]));
            } else {
                stack.push(count(heights[i]));
                while (stack.size() >= 3) {
                    int size = stack.size();
                    Count right = stack.get(size - 1);
                    Count middle = stack.get(size - 2);
                    Count left = stack.get(size - 3);
                    if (middle.val < left.val && middle.val < right.val) {
                        right = stack.pop();
                        middle = stack.pop();
                        left = stack.pop();
                        totalLength += (Math.min(right.val, left.val) - middle.val) * middle.times;
                        if (left.val == right.val) {
                            stack.push(count(left.val, middle.times + left.times + right.times));
                            break;
                        } else if (left.val > right.val) {
                            stack.push(left);
                            stack.push(count(right.val, middle.times + right.times));
                            break;
                        } else {
                            stack.push(count(left.val, middle.times + left.times));
                            stack.push(right);
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return totalLength;
    }

    public int trap2(int[] heights) {
        if (heights == null || heights.length < 3) return 0;

        int totalLength = 0;
        Count[] stack = new Count[heights.length];
        stack[0] = count(heights[0]);
        for (int i = 1, stackSize = 1; i < heights.length; ++i) {
            Count peek = stack[stackSize - 1];
            if (peek.val == heights[i]) {
                peek.times++;
            } else if (peek.val > heights[i]) {
                stack[stackSize++] = count(heights[i]);
            } else {
                stack[stackSize++] = count(heights[i]);
                while (stackSize >= 3) {
                    Count right = stack[stackSize - 1];
                    Count middle = stack[stackSize - 2];
                    Count left = stack[stackSize - 3];
                    if (middle.val < left.val && middle.val < right.val) {
                        totalLength += (Math.min(right.val, left.val) - middle.val) * middle.times;
                        if (left.val == right.val) {
                            stack[stackSize - 3] = count(left.val, middle.times + left.times + right.times);
                            stackSize -= 2;
                            break;
                        } else if (left.val > right.val) {
                            // stack[stackSize - 3] = left;
                            stack[stackSize - 2] = count(right.val, middle.times + right.times);
                            --stackSize;
                            break;
                        } else {
                            stack[stackSize - 3] = count(left.val, middle.times + left.times);
                            stack[stackSize - 2] = right;
                            --stackSize;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return totalLength;
    }

    private class Count {
        int val;
        int times = 1;
    }

}
