package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/delete-and-earn/description/
 *  740. Delete and Earn
 * </pre>
 * on 2018/10/10.
 */
public class Solution740 extends BaseTest {

    @Test
    public void test() {
        assertEquals(6, deleteAndEarn(arr(3, 4, 2)));
        assertEquals(9, deleteAndEarn(arr(2, 2, 3, 3, 3, 4)));
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int[] unique = new int[nums.length], uniqueCount = new int[nums.length];
        unique[0] = nums[0];
        uniqueCount[0] = 1;

        int maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == unique[maxIndex]) {
                ++uniqueCount[maxIndex];
            } else {
                unique[++maxIndex] = nums[i];
                uniqueCount[maxIndex] = 1;
            }
        }

        int[] cache = new int[maxIndex + 1];
        return deleteAndEarn(unique, uniqueCount, 0, cache, maxIndex);
    }

    private int deleteAndEarn(int[] unique, int[] uniqueCount, int from, int[] cache, int maxIndex) {
        if (from > maxIndex) return 0;
        if (cache[from] > 0) return cache[from];

        int result;
        if (from == maxIndex) {
            result = unique[from] * uniqueCount[from];
        } else {
            if (unique[from] + 1 == unique[from + 1]) {
                //choice delete from or not
                result = Math.max(unique[from] * uniqueCount[from] + deleteAndEarn(unique, uniqueCount, from + 2, cache, maxIndex),
                        deleteAndEarn(unique, uniqueCount, from + 1, cache, maxIndex));
            } else {
                result = unique[from] * uniqueCount[from] + deleteAndEarn(unique, uniqueCount, from + 1, cache, maxIndex);
            }
        }
        return cache[from] = result;
    }

}
