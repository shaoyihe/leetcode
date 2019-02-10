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
public class Solution713 {
    @Test
    public void test() {
        Assert.assertEquals(8, numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int total = 0, product = 1, mark = 0;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            if (product >= k) {
                total += i - mark;
                for (product /= nums[mark++]; mark <= i && product >= k; product /= nums[mark++]) {
                    total += i - mark;
                }
            }
        }
        if (product < k && mark < nums.length) {
            for (; mark < nums.length; mark++) {
                total += nums.length - mark;
            }
        }
        return total;
    }

}
