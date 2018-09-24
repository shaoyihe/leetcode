package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *  516. Longest Palindromic Subsequence
 * </pre>
 * on 2018/9/19.
 */
public class Solution516 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, longestPalindromeSubseq("bbbab"));
        assertEquals(2, longestPalindromeSubseq("cbbd"));
        assertEquals(6, longestPalindromeSubseq("aabaaba"));
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[][] cache = new int[s.length()][s.length()];
        return iter(s, 0, s.length() - 1, cache);
    }

    private int iter(String s, int from, int to, int[][] cache) {
        if (from > to) return 0;
        if (from == to) return 1;
        if (cache[from][to] > 0) return cache[from][to];

        int maxLength = 1;
        if (s.charAt(from) == s.charAt(to)) {
            maxLength = 2 + iter(s, from + 1, to - 1, cache);
        } else {
            maxLength = Math.max(maxLength, iter(s, from + 1, to, cache));
            maxLength = Math.max(maxLength, iter(s, from, to - 1, cache));
        }
        return cache[from][to] = maxLength;
    }

}
