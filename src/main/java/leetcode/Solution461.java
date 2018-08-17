package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/hamming-distance/description/
 *  461. Hamming Distance
 * </pre>
 * on 2018/8/2.
 */
public class Solution461 {

    @Test
    public void test() {
        Assert.assertEquals(2, hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int total = 0;
        for (int num = x ^ y; num > 0; num >>>= 1) {
            total += num & 1;
        }
        return total;
    }


}
