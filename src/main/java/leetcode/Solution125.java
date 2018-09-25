package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/valid-palindrome/description/
 *  125. Valid Palindrome
 * </pre>
 * on 2018/09/08.
 */
public class Solution125 extends BaseTest {

    @Test
    public void test() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(isPalindrome("race a car"));
    }


    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        for (int from = 0, to = s.length() - 1; ; ++from, --to) {
            while (from < to && !isAlphanumericChar(s.charAt(from))) ++from;
            while (from < to && !isAlphanumericChar(s.charAt(to))) --to;
            if (from < to) {
                if (Character.toLowerCase(s.charAt(from)) != Character.toLowerCase(s.charAt(to))) return false;
            }else break;
        }

        return true;
    }

    private boolean isAlphanumericChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


}
