package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 *  693. Binary Number with Alternating Bits
 * </pre>
 * on 2018/8/2.
 */
public class Solution693 {

    @Test
    public void test() {
        Assert.assertTrue(hasAlternatingBits(5));
        Assert.assertFalse(hasAlternatingBits(7));

    }

    public boolean hasAlternatingBits(int n) {
        int last = (n & 1);
        for (n >>>= 1; n > 0; n >>>= 1) {
            if (1 != (last ^ (n & 1))) {
                return false;
            }
            last = n & 1;
        }
        return true;
    }
}
