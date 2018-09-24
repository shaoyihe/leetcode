package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/palindromic-substrings/description/
 *  647. Palindromic Substrings
 * </pre>
 * on 2018/9/19.
 */
public class Solution647 extends BaseTest {

    @Test
    public void test() {
        assertEquals(6, countSubstrings("aaa"));
        assertEquals(3, countSubstrings("abc"));
    }

    private final int TRUE = 1;
    private final int FALSE = 2;

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int[][] cache = new int[s.length()][s.length()];
        int result = s.length();
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                boolean isPalindromic = true;
                for (int x = i, y = j; x < y; ++x, --y) {
                    if (cache[x][y] > 0) {
                        isPalindromic = cache[x][y] == TRUE;
                        break;
                    }
                    if (s.charAt(x) != s.charAt(y)) {
                        isPalindromic = false;
                        break;
                    }
                }
                cache[i][j] = isPalindromic ? TRUE : FALSE;
                if (isPalindromic) ++result;
            }
        }
        return result;
    }


}
