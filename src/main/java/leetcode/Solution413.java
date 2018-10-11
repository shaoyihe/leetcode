package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/arithmetic-slices/description/
 *  413. Arithmetic Slices
 * </pre>
 * on 2018/09/08.
 */
public class Solution413 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, numberOfArithmeticSlices(arr(1, 2, 3, 4)));
    }


    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;

        int total = 0;
        int from = 0, difference = A[1] - A[0];
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] != difference) {
                //compute from to i-1
                total += compute(from, i);
                difference = A[i] - A[i - 1];
                from = i - 1;
            }
        }
        total += compute(from, A.length);

        return total;
    }

    private int compute(int from, int to) {
        if (to - from >= 3) {
            return (to - from - 2) * (to - from - 2 + 1) / 2;
        }
        return 0;
    }

}
