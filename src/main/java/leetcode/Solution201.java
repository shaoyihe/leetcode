package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 * 201. Bitwise AND of Numbers Range
 * </pre>
 * on 2018/8/15.
 */
public class Solution201 {

    @Test
    public void test() {
        Assert.assertEquals(0, rangeBitwiseAnd(20000, 2147483647));
        Assert.assertEquals(4, rangeBitwiseAnd(5, 7));
        Assert.assertEquals(0, rangeBitwiseAnd(0, 1));
    }

    public int rangeBitwiseAnd(int m, int n) {
        //last 2^bit <= n
        int bit = 0;
        for (; (1 << (bit + 1)) <= n && bit < 31; ++bit) ;

        int result = 0;
        for (; bit >= 0; --bit) {
            int mBit = (m >>> bit) & 1;
            int nBit = (n >>> bit) & 1;
            if (mBit != nBit) break;
            if (mBit == 1) result |= 1 << bit;
        }
        return result;
    }
}
