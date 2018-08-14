package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/single-number/description/
 * 136. Single Number
 * </pre>
 * on 2018/8/13.
 */
public class Solution136 {

    @Test
    public void test() {

        Assert.assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assert.assertEquals(1, singleNumber(new int[]{2, 2, 1}));

    }

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result ^= nums[i];
        }
        return result;
    }
}
