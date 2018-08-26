package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/house-robber/description/
 *  198. House Robber
 * </pre>
 * on 2018/8/2.
 */
public class Solution198 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, rob(arr(1, 2, 3, 1)));
        assertEquals(12, rob(arr(2, 7, 9, 3, 1)));

    }

    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return rob(nums, 0, cache);
    }

    private int rob(int[] nums, int index, int[] cache) {
        if (index >= nums.length) return 0;
        if (cache[index] >= 0) return cache[index];

        return cache[index] = Math.max(nums[index] + rob(nums, index + 2, cache),
                index + 1 < nums.length ? nums[index + 1] + rob(nums, index + 3, cache) : 0);
    }


}
