package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *  646. Maximum Length of Pair Chain
 * </pre>
 * on 2018/9/26.
 */
public class Solution646 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, findLongestChain(new int[][]{arr(1, 2), arr(2, 3), arr(3, 4)}));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            int first = Integer.compare(o1[0], o2[0]);
            if (first != 0) return first;
            return Integer.compare(o1[1], o2[1]);
        });

        int result = 1;
        int[] mostLengthContainMe = new int[pairs.length];
        mostLengthContainMe[0] = 1;
        for (int i = 1; i < pairs.length; ++i) {
            int curLength = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (pairs[i][0] > pairs[j][1]) {
                    curLength = mostLengthContainMe[j] + 1;
                    break;
                }
            }
            mostLengthContainMe[i] = curLength;
            if (curLength > result) result = curLength;
        }
        return result;
    }

}
