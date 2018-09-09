package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *  132. Palindrome Partitioning II
 * </pre>
 * on 2018/09/08.
 */
public class Solution132 extends BaseTest {

    @Test
    public void test() {
        assertEquals(1, minCut("aab"));
        assertEquals(1, minCut("aabb"));
    }


    public int minCut(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[][] cache = new int[s.length()][s.length()];
        for (int[] temp : cache) Arrays.fill(temp, -1);

        return minCut(s, 0, s.length() - 1, cache);
    }

    private int minCut(String s, int from, int to, int[][] cache) {
        if (from >= to) return 0;
        if (cache[from][to] >= 0) return cache[from][to];

        int minCut = Integer.MAX_VALUE;
        if (isPalindrome(s, from, to)) {
            minCut = 0;
        } else {
            for (int i = from + 1; i <= to; ++i) {
                minCut = Math.min(minCut, minCut(s, from, i - 1, cache) + minCut(s, i, to, cache) + 1);
            }
        }
        return cache[from][to] = minCut;

    }

    private boolean isPalindrome(String s, int from, int to) {
        for (; from < to; ++from, --to) {
            if (s.charAt(from) != s.charAt(to)) return false;
        }
        return true;
    }

}
