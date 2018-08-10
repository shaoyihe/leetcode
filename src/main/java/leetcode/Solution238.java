package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/product-of-array-except-self/description/
 *  238. Product of Array Except Self
 * </pre>
 * on 2018/8/2.
 */
public class Solution238 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));

        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf2(new int[]{1, 2, 3, 4}));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return nums;
        if (nums.length == 1) return new int[]{0};

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result[i] = result[i - 1] * nums[i];
        }
        result[result.length - 1] = result[result.length - 2];
        for (int i = nums.length - 2, product = nums[nums.length - 1]; i >= 0; --i) {
            if (i == 0) {
                result[0] = product;
                break;
            }
            result[i] = product * result[i - 1];
            product *= nums[i];
        }

        return result;
    }


    public int[] productExceptSelf2(int[] nums) {
        if (nums == null) return nums;
        if (nums.length == 1) return new int[]{0};

        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result[i] = result[i - 1] * nums[i];
        }
        result[result.length - 1] = result[result.length - 2];

        int product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; --i) {
            result[i] = product * result[i - 1];
            product *= nums[i];
        }
        result[0] = product;
        return result;
    }

}
