package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/letter-case-permutation/description/
 *  784. Letter Case Permutation
 * </pre>
 * on 2018/8/2.
 */
public class Solution784 {

    @Test
    public void test() {
        Assert.assertEquals(new HashSet<>(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2")), new HashSet<>(letterCasePermutation("a1b2")));
        Assert.assertEquals(new HashSet<>(Arrays.asList("3z4", "3Z4")), new HashSet<>(letterCasePermutation("3z4")));

    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S != null) letterCasePermutation(S.toCharArray(), 0, result, new char[S.length()]);
        return result;
    }


    private void letterCasePermutation(char[] S, int index, List<String> result, char[] current) {
        if (index == S.length) result.add(new String(current));
        else {
            char c = S[index];
            if (c >= 'a' && c <= 'z') {
                //upper
                char[] upperChars = Arrays.copyOf(current, current.length);
                upperChars[index] = Character.toUpperCase(c);
                letterCasePermutation(S, index + 1, result, upperChars);
            } else if (c >= 'A' && c <= 'Z') {
                //lower
                char[] lowerChars = Arrays.copyOf(current, current.length);
                lowerChars[index] = Character.toLowerCase(c);
                letterCasePermutation(S, index + 1, result, lowerChars);
            }
            current[index] = c;
            letterCasePermutation(S, index + 1, result, current);
        }
    }
}
