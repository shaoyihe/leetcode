package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/power-of-four/description/
 * 342. Power of Four
 * </pre>
 * on 2018/8/13.
 */
public class Solution342 {

    @Test
    public void test() {
        Assert.assertTrue(isPowerOfFour(16));
        Assert.assertFalse(isPowerOfFour(5));
    }

    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        for (; num > 1; num >>= 2) {
            if ((num & 3) > 0) return false;
        }
        return true;
    }
}
