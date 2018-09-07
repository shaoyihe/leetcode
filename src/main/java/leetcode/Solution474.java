package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/ones-and-zeroes/description/
 *  474. Ones and Zeroes
 * </pre>
 * on 2018/09/03.
 */
public class Solution474 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        assertEquals(2, findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        assertEquals(2, findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        assertEquals(1, findMaxForm(new String[]{"0", "00", "1"}, 1, 0));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0) return 0;

        int[] countOf0 = new int[strs.length];
        int[] countOf1 = new int[strs.length];
        for (int j = 0; j < strs.length; ++j) {
            String string = strs[j];
            if (string != null || !string.isEmpty()) {
                int cur0 = 0, cur1 = 0;
                for (int i = 0; i < string.length(); ++i) {
                    if (string.charAt(i) == '0') ++cur0;
                    else ++cur1;
                }
                countOf0[j] = cur0;
                countOf1[j] = cur1;
            }
        }

        int[][][] cache = new int[m + 1][n + 1][strs.length];
        for (int[][] a : cache) for (int[] b : a) Arrays.fill(b, -1);

        return findMaxForm(strs, m, n, countOf0, countOf1, 0, cache);
    }

    private int findMaxForm(String[] strs, int m, int n, int[] countOf0, int[] countOf1, int index, int[][][] cache) {
        if (index == strs.length) return 0;
        if (cache[m][n][index] >= 0) return cache[m][n][index];

        int maxNumber = 0;
        if (m >= countOf0[index] && n >= countOf1[index]) {
            // choice index
            maxNumber = findMaxForm(strs, m - countOf0[index], n - countOf1[index], countOf0, countOf1, index + 1, cache) + 1;
        }
        // not choice index
        maxNumber = Math.max(maxNumber, findMaxForm(strs, m, n, countOf0, countOf1, index + 1, cache));

        return cache[m][n][index] = maxNumber;
    }
}
