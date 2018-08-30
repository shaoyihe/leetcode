package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/split-array-largest-sum/description/
 *  410. Split Array Largest Sum
 * </pre>
 * on 2018/8/27.
 */
public class Solution410 extends BaseTest {

    @Test
    public void test() {
        assertEquals(18, splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        return splitArray(nums, m, 0, new int[m + 1][nums.length], new int[nums.length][nums.length]);
    }

    private int splitArray(int[] nums, int m, int index, int[][] cache, int[][] sumCache) {
        if (m == 0) return 0;
        if (cache[m][index] > 0) return cache[m][index];
        if (m == 1) return cache[m][index] = sum(index, nums.length - 1, nums, sumCache);

        int minSum = Integer.MAX_VALUE;
        for (int i = index; i <= nums.length - m; ++i) {
            minSum = Math.min(Math.max(sum(index, i, nums, sumCache), splitArray(nums, m - 1, i + 1, cache, sumCache)), minSum);
        }
        return cache[m][index] = minSum;
    }

    private int sum(int i, int j, int[] nums, int[][] sumCache) {
        if (sumCache[i][j] > 0) return sumCache[i][j];

        int sum = 0;
        for (int t = i; t <= j; ++t) sum += nums[t];
        return sumCache[i][j] = sum;
    }
}
