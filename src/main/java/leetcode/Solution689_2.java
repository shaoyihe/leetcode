package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *  689. Maximum Sum of 3 Non-Overlapping Subarrays
 * </pre>
 * on 2018/9/28.
 */
public class Solution689_2 extends BaseTest {

    @Test
    public void test() {
        assertArrayEquals(arr(0, 3, 5), maxSumOfThreeSubarrays(arr(1, 2, 1, 2, 6, 7, 5, 1), 2));
        assertArrayEquals(arr(4, 5, 7), maxSumOfThreeSubarrays(arr(4, 5, 10, 6, 11, 17, 4, 11, 1, 3), 1));
        assertArrayEquals(arr(0, 3, 6), maxSumOfThreeSubarrays(arr(18, 11, 14, 7, 16, 4, 18, 11, 4, 8), 2));
        assertArrayEquals(arr(10, 29, 36), maxSumOfThreeSubarrays(arr(1, 17, 16, 10, 6, 18, 1, 1, 16, 12, 9, 20, 14, 15, 5, 17, 20, 16, 4, 3, 3, 17, 13, 9, 16, 3, 8, 8, 14, 12, 20, 14, 20, 9, 1, 12, 14, 17, 15, 19), 4));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] cache = new int[3][nums.length - k + 1];
        int[] rangeValues = new int[nums.length - k + 1];

        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        rangeValues[0] = sum;
        for (int i = k, from = 0; i < nums.length; ++i) {
            sum += nums[i] - nums[from];
            rangeValues[++from] = sum;
        }

        int maxValue = maxSumOfThreeSubarrays(rangeValues, cache, 0, 0, nums, k);
        int[] result = new int[3];
        for (int i = 0; i < cache.length; ++i) {
            for (int j = cache[i].length - 1; j >= 0; --j) {
                if (maxValue == cache[i][j]) {
                    maxValue -= rangeValues[j];
                    result[i] = j;
                    break;
                }
            }
        }
        return result;
    }

    private int maxSumOfThreeSubarrays(int[] rangeValues, int[][] cache, int query, int index, int[] nums, int k) {
        if (cache[query][index] > 0) return cache[query][index];

        int maxValue = 0, maxIndex = 0;
        for (int i = index, limit = nums.length - (3 - query) * k, curQueryVal = 0; i <= limit; ++i) {
            int curRangeValue = rangeValues[i];
            if (curRangeValue > curQueryVal) {
                curQueryVal = curRangeValue;

                if (query < 2) {
                    int back = maxSumOfThreeSubarrays(rangeValues, cache, query + 1, i + k, nums, k);
                    if (curRangeValue + back > maxValue) {
                        maxValue = curRangeValue + back;
                        maxIndex = i;
                    }
                } else {
                    if (curRangeValue > maxValue) {
                        maxValue = curRangeValue;
                        maxIndex = i;
                    }
                }
            }
        }
        Arrays.fill(cache[query], index, maxIndex + 1, maxValue);
        return maxValue;
    }


}
