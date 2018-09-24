package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 *  467. Unique Substrings in Wraparound String
 * </pre>
 * on 2018/9/19.
 */
public class Solution467 extends BaseTest {

    @Test
    public void test() {
        assertEquals(2, findSubstringInWraproundString("cac"));
        assertEquals(6, findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.isEmpty()) return 0;
        if (p.length() == 1) return 1;

        //26 个字母
        int[] maxLengthFromCurChar = new int[26];
        int from = 0;
        for (int i = 1; i < p.length(); ++i) {
            if ((p.charAt(i - 1) == 'z' && p.charAt(i) == 'a') || p.charAt(i) - p.charAt(i - 1) == 1) {
                // found
            } else {
                //reset
                write(maxLengthFromCurChar, p, from, i);
                from = i;
            }
        }
        write(maxLengthFromCurChar, p, from, p.length());
        return Arrays.stream(maxLengthFromCurChar).sum();
    }

    private void write(int[] maxLengthFromCurChar, String p, int from, int to) {
        for (int i = from; i < to; ++i) {
            int index = p.charAt(i) - 'a';
            if (maxLengthFromCurChar[index] < to - i) maxLengthFromCurChar[index] = to - i;
        }
    }

}
