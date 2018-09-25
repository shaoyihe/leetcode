package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/out-of-boundary-paths/description/
 *  576. Out of Boundary Paths
 * </pre>
 * on 2018/9/21.
 */
public class Solution576 extends BaseTest {

    @Test
    public void test() {
        assertEquals(6, findPaths(2, 2, 2, 0, 0));
        assertEquals(12, findPaths(1, 3, 3, 0, 1));
        assertEquals(390153306, findPaths(36, 5, 50, 15, 3));
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] cache = new long[m][n][N];
        for (long[][] a : cache) for (long[] temp : a) Arrays.fill(temp, -1);
        return (int) findPaths(m, n, N, i, j, 0, cache);
    }

    private final int MODE_VAL = (int) (Math.pow(10, 9)) + 7;

    private long findPaths(int m, int n, int N, int i, int j, int times, long[][][] cache) {
        if (i < 0 || j < 0 || i == m || j == n) return 1;
        if (times == N) return 0;

        if (cache[i][j][times] >= 0) return cache[i][j][times];
        return cache[i][j][times] = (findPaths(m, n, N, i + 1, j, times + 1, cache) + findPaths(m, n, N, i - 1, j, times + 1, cache) +
                findPaths(m, n, N, i, j + 1, times + 1, cache) + findPaths(m, n, N, i, j - 1, times + 1, cache)) % MODE_VAL;
    }

}
