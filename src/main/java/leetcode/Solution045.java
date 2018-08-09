package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.TreeSet;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-linked-list-ii/
 *  92. Reverse Linked List II
 * </pre>
 * on 2018/8/2.
 */

public class Solution045 {

    @Test
    public void test() {
        Assert.assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(1, jump(new int[]{1, 5}));
        Assert.assertEquals(3, jump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));

        Assert.assertEquals(2, jump2(new int[]{2, 3, 1, 1, 4}));
        Assert.assertEquals(1, jump2(new int[]{1, 5}));
        Assert.assertEquals(3, jump2(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }

    /**
     * time out
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int[] minJumpToLast = new int[nums.length];
        TreeSet<Integer> sortByMin = new TreeSet<>((o1, o2) -> minJumpToLast[o1] > minJumpToLast[o2] ? 1 : (minJumpToLast[o1] == minJumpToLast[o2] ? o1.compareTo(o2) : -1));

        sortByMin.add(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; --i) {
            int maxPos = nums[i] + i, curMinJumpToLast = Integer.MAX_VALUE;
            if (nums[i] == 1) {
                curMinJumpToLast = minJumpToLast[i + 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : minJumpToLast[i + 1] + 1;
            } else if (nums[i] > 1) {
                for (Integer lastMinJumpToLastPos : sortByMin) {
                    if (maxPos >= lastMinJumpToLastPos) {
                        curMinJumpToLast = minJumpToLast[lastMinJumpToLastPos] == Integer.MAX_VALUE ? minJumpToLast[lastMinJumpToLastPos] : minJumpToLast[lastMinJumpToLastPos] + 1;
                        break;
                    }
                }
            }
            minJumpToLast[i] = curMinJumpToLast;
            sortByMin.add(i);
        }
        return minJumpToLast[0];
    }

    public int jump2(int[] nums) {
        int step = 0;
        for (int i = 0, maxPos = 0, lastPos = 0; i < nums.length; ++i) {
            if (lastPos < i) {
                lastPos = maxPos;
                ++step;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return step;
    }
}
