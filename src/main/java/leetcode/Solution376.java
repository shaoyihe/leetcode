package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/wiggle-subsequence/description/
 * 376. Wiggle Subsequence
 * </pre>
 * on 2018/09/11.
 */
public class Solution376 extends BaseTest {

    @Test
    public void test() {
        assertEquals(6, wiggleMaxLength(arr(1, 7, 4, 9, 2, 5)));
        assertEquals(7, wiggleMaxLength(arr(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)));
        assertEquals(2, wiggleMaxLength(arr(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertEquals(1, wiggleMaxLength(arr(0, 0)));
        assertEquals(1, wiggleMaxLength(arr(0)));
    }

    @Test
    public void test2() {
        assertEquals(6, wiggleMaxLength2(arr(1, 7, 4, 9, 2, 5)));
        assertEquals(7, wiggleMaxLength2(arr(1, 17, 5, 10, 13, 15, 10, 5, 16, 8)));
        assertEquals(2, wiggleMaxLength2(arr(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertEquals(1, wiggleMaxLength2(arr(0, 0)));
        assertEquals(1, wiggleMaxLength2(arr(0)));
    }

    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] asAsc = new int[nums.length], asDesc = new int[nums.length];
        asAsc[0] = 1;
        asDesc[0] = 1;

        int maxLength = 1;
        for (int i = 1; i < nums.length; ++i) {
            int ascCount = 0, descCount = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    ascCount = Math.max(ascCount, asDesc[j] + 1);
                } else if (nums[i] < nums[j]) {
                    descCount = Math.max(descCount, asAsc[j] + 1);
                }
            }
            asAsc[i] = ascCount;
            asDesc[i] = descCount;
            maxLength = Math.max(maxLength, Math.max(ascCount, descCount));
        }
        return maxLength;
    }


    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int EQUAL = 0, LESS = 1, GREATER = 2;

        int maxLength = 1;
        for (int i = 1, lastDifference = EQUAL, lastVal = nums[0]; i < nums.length; ++i) {
            if (nums[i] > lastVal) {
                if (lastDifference == EQUAL || lastDifference == LESS) {
                    lastDifference = GREATER;
                    ++maxLength;
                }
            } else if (nums[i] < lastVal) {
                if (lastDifference == EQUAL || lastDifference == GREATER) {
                    lastDifference = LESS;
                    ++maxLength;
                }
            }
            lastVal = nums[i];
        }
        return maxLength;
    }

}
