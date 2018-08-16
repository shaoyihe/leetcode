package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/number-complement/description/
 *  476. Number Complement
 * </pre>
 * on 2018/8/2.
 */
public class Solution476 {

    @Test
    public void test() {
        Assert.assertEquals(2, findComplement(5));
        Assert.assertEquals(0, findComplement(1));
    }

    public int findComplement(int num) {
        int result = 0;
        for (int i = 0; num > 0; ++i, num >>= 1) {
            if ((num & 1) == 0) result |= 1 << i;
        }
        return result;
    }


}
