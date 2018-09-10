package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/create-maximum-number/description/
 *  321. Create Maximum Number
 * </pre>
 * on 2018/09/03.
 */
public class Solution321 extends BaseTest {

    @Test
    public void test() {
        assertArrEqual(arr(9, 8, 6, 5, 3), maxNumber(arr(3, 4, 6, 5), arr(9, 1, 2, 5, 8, 3), 5));
        assertArrEqual(arr(6, 7, 6, 0, 4), maxNumber(arr(6, 7), arr(6, 0, 4), 5));
        assertArrEqual(arr(7, 3, 8, 2, 5, 6, 4, 4, 0, 6, 5, 7, 6, 2, 0), maxNumber(arr(2, 5, 6, 4, 4, 0), arr(7, 3, 8, 0, 6, 5, 7, 6, 2), 15));
        assertArrEqual(arr(9, 5, 7, 6, 5, 6, 2, 4, 3, 6, 2, 2, 2, 1, 3, 0, 2, 8, 9, 7, 7, 3, 2, 2, 9, 4, 5, 1), maxNumber(arr(9, 5, 6, 2, 4, 3, 6, 2), arr(5, 7, 6, 2, 2, 1, 3, 0, 2, 8, 9, 7, 7, 3, 2, 2, 9, 4, 5, 1), 28));
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        Arrays.fill(result, -1);
        maxNumber(nums1, nums2, k, 0, 0, 0, result, false);
        return result;
    }

    private void maxNumber(int[] nums1, int[] nums2, int k, int index, int num1Index, int num2Index, int[] result, boolean rewrite) {
        if (index == result.length) return;

        //find num1 max in optional position
        int num1Max = -1;
        final int num1Limit = nums1.length - Math.max(0, k - 1 - (nums2.length - num2Index));
        for (int i = num1Index; i < num1Limit; ++i) {
            if (nums1[i] > num1Max) num1Max = nums1[i];
        }

        //find num2 max in optional position
        int num2Max = -1;
        final int num2Limit = nums2.length - Math.max(0, (k - 1 - (nums1.length - num1Index)));
        for (int i = num2Index; i < num2Limit; ++i) {
            if (nums2[i] > num2Max) num2Max = nums2[i];
        }

        final int curMax = Math.max(num1Max, num2Max);
        if (rewrite || curMax >= result[index]) {
            final boolean newRewrite = rewrite | (result[index] >= 0 && curMax > result[index]);
            int rewriteTime = 0;
            result[index] = curMax;

            if (curMax == num1Max) {
                for (int i = num1Index; i < num1Limit; ++i) {
                    if (nums1[i] == curMax) {
                        maxNumber(nums1, nums2, k - 1, index + 1, i + 1, num2Index, result, (++rewriteTime) == 1 && newRewrite);
                    }
                }
            }
            if (curMax == num2Max) {
                for (int i = num2Index; i < num2Limit; ++i) {
                    if (nums2[i] == curMax) {
                        maxNumber(nums1, nums2, k - 1, index + 1, num1Index, i + 1, result, (++rewriteTime) == 1 && newRewrite);
                    }
                }
            }

        }
    }
}
