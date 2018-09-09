package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 *  674. Longest Continuous Increasing Subsequence
 * </pre>
 * on 2018/09/08.
 */
public class Solution674 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, findLengthOfLCIS(arr(1, 3, 5, 4, 7)));
    }


    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int mostLength = 1;
        for (int i = 1, times = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) ++times;
            else times = 1;
            if (times > mostLength) mostLength = times;
        }
        return mostLength;
    }

}
