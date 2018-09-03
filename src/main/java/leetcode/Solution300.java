package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-increasing-subsequence/description/
 *  300. Longest Increasing Subsequence
 * </pre>
 * on 2018/09/03.
 */
public class Solution300 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, lengthOfLIS(arr(10, 9, 2, 5, 3, 7, 101, 18)));
    }

    private final int NOT_CHOICE = -1;

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return lengthOfLIS(nums, 0, cache, NOT_CHOICE);
    }

    private int lengthOfLIS(int[] nums, int index, int[] cache, int lastChoice) {
        if (index == nums.length) return 0;

        //
        int max = 0;
        if (lastChoice == NOT_CHOICE || nums[index] > nums[lastChoice]) {
            if (cache[index] == -1) {
                cache[index] = 1 + lengthOfLIS(nums, index + 1, cache, index);
            }
            max = cache[index];
        }

        return Math.max(max, lengthOfLIS(nums, index + 1, cache, lastChoice));
    }


}
