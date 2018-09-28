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
public class Solution689 extends BaseTest {

    @Test
    public void test() {
        assertArrayEquals(arr(0, 3, 5), maxSumOfThreeSubarrays(arr(1, 2, 1, 2, 6, 7, 5, 1), 2));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][][] cache = new int[3][nums.length][4];
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

        return Arrays.copyOfRange(maxSumOfThreeSubarrays(rangeValues, cache, 0, 0, nums, k), 1, 4);
    }

    private int[] maxSumOfThreeSubarrays(int[] rangeValues, int[][][] cache, int query, int index, int[] nums, int k) {
        if (cache[query][index][0] > 0) return cache[query][index];

        int[] result = new int[4];
        for (int i = index, limit = nums.length - (3 - query) * k, curQueryVal = 0; i <= limit; ++i) {
            int curRangeValue = rangeValues[i];
            if (curRangeValue > curQueryVal) {
                if (query < 2) {
                    int[] backs = maxSumOfThreeSubarrays(rangeValues, cache, query + 1, i + k, nums, k);
                    if (curRangeValue + backs[0] > result[0]) {
                        result[0] = curRangeValue + backs[0];
                        result[1] = i;
                        for (int t = query + 1, resultIndex = 2, fromIndex = 1; t <= 2; ++t) {
                            result[resultIndex++] = backs[fromIndex++];
                        }
                    }
                } else {
                    if (curRangeValue > result[0]) {
                        result[0] = curRangeValue;
                        result[1] = i;
                    }
                }
            }
        }
        return cache[query][index] = result;
    }


}
