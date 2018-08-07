package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <pre>
 *  https://leetcode.com/problems/compare-version-numbers/description/
 *  165. Compare Version Numbers
 * </pre>
 * on 2018/8/2.
 */

public class Solution165 {

    @Test
    public void test() {
        assertEquals(-1, compareVersion("0.1", "1.1"));
        assertEquals(-1, compareVersion("7.5.2.4", "7.5.3"));
        assertEquals(1, compareVersion("1.0.1", "1"));
        assertEquals(0, compareVersion("01", "1"));
        assertEquals(0, compareVersion("1.0", "1"));
    }

    public int compareVersion(String version1, String version2) {
        for (int i = 0, j = 0; ; ) {
            //find version . pso
            int pos1;
            for (pos1 = i; pos1 + 1 < version1.length() && version1.charAt(pos1 + 1) != '.'; ++pos1) ;
            for (; i + 1 < version1.length() && version1.charAt(i) == '0'; ++i) ;

            int pos2;
            for (pos2 = j; pos2 + 1 < version2.length() && version2.charAt(pos2 + 1) != '.'; ++pos2) ;
            for (; j + 1 < version2.length() && version2.charAt(j) == '0'; ++j) ;

            if (pos1 - i > pos2 - j) return 1;
            if (pos2 - j > pos1 - i) return -1;

            //judge
            for (int t = i; t <= pos1; ++t) {
                if (version1.charAt(t) > version2.charAt(j + t - i)) return 1;
                if (version1.charAt(t) < version2.charAt(j + t - i)) return -1;
            }

            i = pos1 + 1;
            j = pos2 + 1;

            if (i == version1.length()) {
                return j == version2.length() ? 0 : -1;
            }
            if (j == version2.length()) return 1;
        }
    }
}
