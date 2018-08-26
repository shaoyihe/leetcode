package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/house-robber-ii/description/
 *  213. House Robber II
 * </pre>
 * on 2018/8/2.
 */
public class Solution213 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, rob(arr(2, 3, 2)));
        assertEquals(4, rob(arr(1, 2, 3, 1)));
        assertEquals(3, rob(arr(2, 1, 1, 2)));
        assertEquals(2, rob(arr(1, 2)));
        assertEquals(16, rob(arr(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)));

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[][] cache = new int[2][nums.length];
        for (int i = 0; i < 2; ++i) Arrays.fill(cache[i], -1);
        return Math.max(Math.max(nums[0] + rob(nums, 2, cache, 0), nums[1] + rob(nums, 3, cache, 1)),
                nums[2] + rob(nums, 4, cache, 1));
    }

    private int rob(int[] nums, int index, int[][] cache, int fromStart) {
        if (index >= nums.length) return 0;
        if (cache[fromStart][index] >= 0) return cache[fromStart][index];

        if (index == nums.length - 1) return cache[fromStart][index] = fromStart == 0 ? 0 : nums[index];

        return cache[fromStart][index] = Math.max(nums[index] + rob(nums, index + 2, cache, fromStart),
                (index + 1 < nums.length - 1 || (index + 1 == nums.length - 1 && fromStart != 0)) ? nums[index + 1] + rob(nums, index + 3, cache, fromStart) : 0);
    }


}
