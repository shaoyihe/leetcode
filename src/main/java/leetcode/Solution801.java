package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/
 *  801. Minimum Swaps To Make Sequences Increasing
 * </pre>
 * on 2018/10/10.
 */
public class Solution801 extends BaseTest {

    @Test
    public void test() {
        assertEquals(1, minSwap(arr(1, 3, 5, 4), arr(1, 2, 3, 7)));
    }

    public int minSwap(int[] A, int[] B) {
        int[][] cache = new int[2][A.length];
        for (int[] temp : cache) Arrays.fill(temp, -2);
        return minSwap(A, B, 1, A[0], B[0], cache);
    }

    private int minSwap(int[] A, int[] B, int index, int ALastVal, int bLastVal, int[][] cache) {
        if (index == A.length) return 0;
        if (ALastVal == A[index - 1]) {
            if (cache[0][index] != -2) return cache[0][index];
        } else {
            if (cache[1][index] != -2) return cache[1][index];
        }

        int result = -1;

        if (A[index] <= ALastVal || B[index] <= bLastVal) {
            //most swap
            if (B[index] > ALastVal && A[index] > bLastVal) {
                // swapMinSwap index
                int swapMinSwap = minSwap(A, B, index + 1, B[index], A[index], cache);
                if (swapMinSwap != -1) swapMinSwap += 1;

                if (index < A.length / 2) {
                    int swapBeforeMin = minSwap(A, B, index + 1, A[index], B[index], cache);
                    if (swapBeforeMin != -1) {
                        swapBeforeMin += index; // swap 0 -> index -1
                        if (swapMinSwap == -1) swapMinSwap = swapBeforeMin;
                        else swapMinSwap = Math.min(swapMinSwap, swapBeforeMin);
                    }
                }

                result = swapMinSwap;
            }
        } else {
            // may swap
            int normalMinSwap = minSwap(A, B, index + 1, A[index], B[index], cache);

            if (index < A.length - 1 && B[index] > ALastVal && A[index] > bLastVal) {
                int nextSwap = minSwap(A, B, index + 1, B[index], A[index], cache);
                if (nextSwap != -1) {
                    nextSwap += 1;
                    if (normalMinSwap == -1) normalMinSwap = nextSwap;
                    else normalMinSwap = Math.min(normalMinSwap, nextSwap);
                }
            }
            result = normalMinSwap;
        }
        if (ALastVal == A[index - 1]) {
            cache[0][index] = result;
        } else {
            cache[1][index] = result;
        }
        return result;
    }

}
