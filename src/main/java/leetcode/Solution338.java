package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/counting-bits/description/
 * 338. Counting Bits
 * </pre>
 * on 2018/8/13.
 */
public class Solution338 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1, borderPos = 1, incrPos = 1; i < result.length; ++i) {
            if (incrPos == borderPos) {
                result[i] = 1;
                incrPos = 1;
                borderPos = i;
            } else {
                result[i] = 1 + result[incrPos++];
            }
        }
        return result;
    }
}
