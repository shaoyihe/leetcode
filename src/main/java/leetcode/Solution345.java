package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *  345. Reverse Vowels of a String
 * </pre>
 * on 2018/09/03.
 */
public class Solution345 extends BaseTest {

    @Test
    public void test() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;

        char[] result = s.toCharArray();
        for (int i = 0, j = result.length - 1; j > i; ++i, --j) {
            for (; i < j && !isVowel(result[i]); ++i) ;
            for (; i < j && !isVowel(result[j]); --j) ;
            if (i < j) {
                //swap
                char temp = result[i];
                result[i] = result[j];
                result[j] = temp;
            }
        }
        return new String(result);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
