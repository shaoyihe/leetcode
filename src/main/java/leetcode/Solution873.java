package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/
 *  873. Length of Longest Fibonacci Subsequence
 * </pre>
 * on 2018/8/27.
 */
public class Solution873 extends BaseTest {

    @Test
    public void test() {
        assertEquals(5, lenLongestFibSubseq(arr(1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(3, lenLongestFibSubseq(arr(1, 3, 7, 11, 12, 14, 18)));
    }

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> AElements = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            AElements.put(A[i], i);
        }
        int[][] maxLengths = new int[A.length][A.length];
        for (int[] temp : maxLengths) Arrays.fill(temp, -1);

        int result = 0;
        for (int i = 0; i < A.length - result; ++i) {
            for (int j = i + 1; j < A.length - result; ++j) {
                int maxLength = lenLongestFibSubseq(A, AElements, maxLengths, i, j);
                if (maxLength > result) result = maxLength;
            }
        }
        return result > 0 ? result + 2 : 0;
    }

    private int lenLongestFibSubseq(int[] A, Map<Integer, Integer> AElements, int[][] maxLengths, int i, int j) {
        if (maxLengths[i][j] >= 0) return maxLengths[i][j];
        Integer targetIndex = AElements.get(A[i] + A[j]);
        if (targetIndex == null) {
            return maxLengths[i][j] = 0;
        } else {
            return maxLengths[i][j] = 1 + lenLongestFibSubseq(A, AElements, maxLengths, j, targetIndex);
        }
    }
}
