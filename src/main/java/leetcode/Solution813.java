package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/largest-sum-of-averages/description/
 *  813. Largest Sum of Averages
 * </pre>
 * on 2018/8/2.
 */
public class Solution813 extends BaseTest {

    @Test
    public void test() {
        assertEquals(20, largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3), 0);
        assertEquals(20.5, largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4), 0);
    }

    public double largestSumOfAverages(int[] A, int K) {
        return largestSumOfAverages(A, K, 0, new double[K + 1][A.length]);

    }

    private double largestSumOfAverages(int[] A, int K, int index, double[][] cache) {
        if (index == A.length) return 0;
        if (cache[K][index] > 0) return cache[K][index];
        if (K == 1) return cache[K][index] = avg(index, A.length - 1, A);

        double max = 0;
        for (int i = index; i <= A.length - K + 1; ++i) {
            max = Math.max(max, avg(index, i, A) + largestSumOfAverages(A, K - 1, i + 1, cache));
        }
        return cache[K][index] = max;
    }

    private double avg(int from, int to, int[] A) {
        double total = 0;
        for (int i = from; i <= to; ++i) total += A[i];
        return total / (to - from + 1);
    }
}
