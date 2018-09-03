package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/russian-doll-envelopes/description/
 *  354. Russian Doll Envelopes
 * </pre>
 * on 2018/09/03.
 */
public class Solution354_2 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int[] cache = new int[envelopes.length];
        Arrays.fill(cache, -1);
        return maxEnvelopes(envelopes, 0, cache, NOT_CHOICE);
    }

    private int maxEnvelopes(int[][] envelopes, int index, int[] cache, int lastChoiceIndex) {
        if (index == envelopes.length) return 0;

        int max = 0;
        if (canChoice(index, lastChoiceIndex, envelopes)) {
            // choice index
            if (cache[index] == -1) {
                cache[index] = 1 + maxEnvelopes(envelopes, index + 1, cache, index);
            }
            max = cache[index];
        }
        // not choice index
        return Math.max(max, maxEnvelopes(envelopes, index + 1, cache, lastChoiceIndex));
    }

    private final int NOT_CHOICE = -1;

    private boolean canChoice(int index, int lastChoiceIndex, int[][] envelopes) {
        return lastChoiceIndex == NOT_CHOICE || (envelopes[index][0] > envelopes[lastChoiceIndex][0] && envelopes[index][1] > envelopes[lastChoiceIndex][1]);
    }
}
