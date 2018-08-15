package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/missing-number/description/
 * 268. Missing Number
 * </pre>
 * on 2018/8/15.
 */
public class Solution268 {

    @Test
    public void test() {
        Assert.assertEquals(2, missingNumber(new int[]{3, 0, 1}));
        Assert.assertEquals(8, missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int oriSum = (nums.length) * (nums.length + 1) / 2;
        for (int num : nums) oriSum -= num;
        return oriSum;
    }
}
