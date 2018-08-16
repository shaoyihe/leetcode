package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-bits/description/
 * 190. Reverse Bits
 * </pre>
 * on 2018/8/15.
 */
public class Solution190 {

    @Test
    public void test() {
        Assert.assertEquals(964176192, reverseBits(43261596));
    }

    public int reverseBits(int n) {
        int result = 0;
        if ((n & 1) == 1) result = Integer.MIN_VALUE;
        n >>>= 1;

        for (int bit = 30; n > 0; --bit, n >>= 1) {
            if ((n & 1) == 1) result |= 1 << bit;
        }
        return result;
    }
}
