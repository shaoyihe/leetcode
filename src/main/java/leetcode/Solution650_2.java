package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/2-keys-keyboard/description/
 *  650. 2 Keys Keyboard
 * </pre>
 * on 2018/09/03.
 */
public class Solution650_2 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, minSteps(3));
        assertEquals(6, minSteps(9));
    }

    public int minSteps(int n) {
        if (n == 1) return 0;
        return 1 + minSteps(n - 1, 1, 1, new int[n / 2 + 1][n + 1]);
    }

    private final int NOT_REACH = -1;

    private int minSteps(int remainN, int paperN, int copyANumber, int[][] cache) {
        if (remainN == 0) return 0;
        if (remainN < 0 || copyANumber > remainN) return NOT_REACH;

        if (cache[copyANumber][paperN] != 0) return cache[copyANumber][paperN];

        int minStep = NOT_REACH;
        // paste
        int nextMinStep = minSteps(remainN - copyANumber, paperN + copyANumber, copyANumber, cache);
        if (nextMinStep != NOT_REACH) minStep = nextMinStep + 1;

        if (copyANumber < paperN) {
            // copy
            nextMinStep = minSteps(remainN, paperN, paperN, cache);
            if (nextMinStep != NOT_REACH) {
                if (minStep == NOT_REACH) minStep = 1 + nextMinStep;
                else minStep = Math.min(minStep, 1 + nextMinStep);
            }
        }
        return cache[copyANumber][paperN] = minStep;
    }
}
