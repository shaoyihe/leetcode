package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/interleaving-string/description/
 *  97. Interleaving String
 * </pre>
 * on 2018/8/2.
 */
public class Solution097 extends BaseTest {

    @Test
    public void test() {
        assertTrue(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        assertTrue(isInterleave2("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(isInterleave2("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0, 0);

    }

    public boolean isInterleave(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index) {
        if (s3Index == s3.length()) return true;

        if (s1Index < s1.length()) {
            if (s1.charAt(s1Index) == s3.charAt(s3Index) && isInterleave(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1)) {
                return true;
            }
        }

        if (s2Index < s2.length()) {
            if (s2.charAt(s2Index) == s3.charAt(s3Index) && isInterleave(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * cache
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0, 0, new int[s1.length() + 1][s2.length() + 1]);

    }

    public boolean isInterleave(String s1, String s2, String s3, int s1Index, int s2Index, int s3Index, int[][] cache) {
        if (s3Index == s3.length()) return true;

        if (cache[s1Index][s2Index] > 0) return false;

        if (s1Index < s1.length()) {
            if (s1.charAt(s1Index) == s3.charAt(s3Index) && isInterleave(s1, s2, s3, s1Index + 1, s2Index, s3Index + 1, cache)) {
                return true;
            }
        }

        if (s2Index < s2.length()) {
            if (s2.charAt(s2Index) == s3.charAt(s3Index) && isInterleave(s1, s2, s3, s1Index, s2Index + 1, s3Index + 1, cache)) {
                return true;
            }
        }

        //mark false
        cache[s1Index][s2Index] = 1;
        return false;
    }

}
