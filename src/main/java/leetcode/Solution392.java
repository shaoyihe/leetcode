package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/is-subsequence/description/
 *  392. Is Subsequence
 * </pre>
 * on 2018/09/03.
 */
public class Solution392 extends BaseTest {

    @Test
    public void test() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        return isSubsequence(s, t, 0, 0, new int[s.length()][t.length()]);
    }

    private boolean isSubsequence(String s, String t, int sIndex, int tIndex, int[][] cache) {
        if (sIndex == s.length()) return true;
        if (s.length() - sIndex > t.length() - tIndex) return false;

        if (cache[sIndex][tIndex] == 0) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                if (isSubsequence(s, t, sIndex + 1, tIndex + 1, cache)) {
                    return true;
                }
            }
            if (isSubsequence(s, t, sIndex, tIndex + 1, cache)) {
                return true;
            }
            cache[sIndex][tIndex] = 1;
        }
        return false;
    }
}
