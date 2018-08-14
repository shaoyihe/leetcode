package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/power-of-two/description/
 *  231. Power of Two
 * </pre>
 * on 2018/8/12.
 */
public class Solution231 {

    @Test
    public void test() {
        Assert.assertTrue(isPowerOfTwo(1));
        Assert.assertTrue(isPowerOfTwo(16));
        Assert.assertFalse(isPowerOfTwo(218));

    }


    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        for (; n > 1; n >>= 1) {
            if ((n & 1) == 1) return false;
        }
        return true;
    }

}
