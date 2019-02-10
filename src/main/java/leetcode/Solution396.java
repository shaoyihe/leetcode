package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/rotate-function/
 *  396. Rotate Function
 * </pre>
 * on 2018/8/2.
 */
public class Solution396 {
    @Test
    public void test() {
        Assert.assertEquals(26, maxRotateFunction(new int[]{4, 3, 2, 6}));
    }


    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1) return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            int sum = 0;
            for (int j = 0; j < A.length; ++j) {
                sum += j * A[(i + j) % A.length];
            }
            if (sum > max) max = sum;
        }
        return max;
    }

}
