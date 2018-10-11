package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 *  712. Minimum ASCII Delete Sum for Two Strings
 * </pre>
 * on 2018/10/08.
 */
public class Solution712 extends BaseTest {

    @Test
    public void test() {
        assertEquals(231, minimumDeleteSum("sea", "eat"));
        assertEquals(403, minimumDeleteSum("delete", "leet"));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int[][] cache = new int[s1.length() + 1][s2.length() + 1];
        for (int[] temp : cache) Arrays.fill(temp, -1);
        return minimumDeleteSum(s1, s2, 0, 0, cache);
    }

    private int minimumDeleteSum(String s1, String s2, int fromS1, int fromS2, int[][] cache) {
        if (cache[fromS1][fromS2] >= 0) return cache[fromS1][fromS2];

        int result;
        if (fromS1 == s1.length()) {
            result = asciiSum(s2, fromS2);
        } else if (fromS2 == s2.length()) {
            result = asciiSum(s1, fromS1);
        } else if (s1.charAt(fromS1) == s2.charAt(fromS2)) {
            result = minimumDeleteSum(s1, s2, fromS1 + 1, fromS2 + 1, cache);
        } else {
            result = Math.min(minimumDeleteSum(s1, s2, fromS1 + 1, fromS2, cache) + s1.charAt(fromS1),
                    minimumDeleteSum(s1, s2, fromS1, fromS2 + 1, cache) + s2.charAt(fromS2));
        }
        return cache[fromS1][fromS2] = result;
    }

    private int asciiSum(String s, int from) {
        int sum = 0;
        for (int i = from, length = s.length(); i < length; ++i) sum += s.charAt(i);
        return sum;
    }
}
