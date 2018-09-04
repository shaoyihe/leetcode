package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/largest-divisible-subset/description/
 *  368. Largest Divisible Subset
 * </pre>
 * on 2018/09/04.
 */
public class Solution368 extends BaseTest {

    @Test
    public void test() {
        assertToSetEqual(Arrays.asList(1, 2, 4, 8), largestDivisibleSubset(arr(1, 2, 4, 8)));
        assertToSetEqual(Arrays.asList(4, 8, 16), largestDivisibleSubset(arr(3, 4, 16, 8)));
    }


    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);

        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1);
        int[] beforeIndex = new int[nums.length];
        Arrays.fill(beforeIndex, -1);

        int maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] % nums[j] == 0 && cache[j] + 1 > cache[i]) {
                    cache[i] = cache[j] + 1;
                    beforeIndex[i] = j;
                }
                if (cache[i] > cache[maxIndex]) maxIndex = i;
            }
        }
        for (; maxIndex != -1; maxIndex = beforeIndex[maxIndex]) {
            result.add(nums[maxIndex]);
        }
        return result;
    }


}
