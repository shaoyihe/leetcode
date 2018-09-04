package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/is-subsequence/description/
 *  392. Is Subsequence
 * </pre>
 * on 2018/09/03.
 */
public class Solution392_2 extends BaseTest {

    @Test
    public void test() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        for (int i = 0, tIndex = 0; i < s.length(); ++i) {
            boolean found = false;
            for (; tIndex < t.length(); ++tIndex) {
                if (s.charAt(i) == t.charAt(tIndex)) {
                    ++tIndex;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

}
