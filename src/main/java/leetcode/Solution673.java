package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 *  673. Number of Longest Increasing Subsequence
 * </pre>
 * on 2018/09/08.
 */
public class Solution673 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, findNumberOfLIS(arr(1, 3, 5, 4, 7)));
        assertEquals(5, findNumberOfLIS(arr(2, 2, 2, 2, 2)));
        assertEquals(3, findNumberOfLIS(arr(1, 2, 4, 3, 5, 4, 7, 2)));
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] mostLongestContainMe = new int[nums.length], times = new int[nums.length];

        int mostLongest = 1, total = 0;
        for (int i = 0; i < nums.length; ++i) {
            int time = 1, max = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i]) {
                    if (mostLongestContainMe[j] > max) {
                        max = mostLongestContainMe[j];
                        time = times[j];
                    } else if (mostLongestContainMe[j] == max) {
                        time += times[j];
                    }
                }
            }
            times[i] = time;
            mostLongestContainMe[i] = max + 1;
            if (mostLongestContainMe[i] > mostLongest) {
                mostLongest = mostLongestContainMe[i];
                total = times[i];
            } else if (mostLongestContainMe[i] == mostLongest) total += times[i];
        }

        return total;
    }

}
