package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/repeated-dna-sequences/description/
 *  187. Repeated DNA Sequences
 * </pre>
 * on 2018/8/2.
 */
public class Solution187 extends BaseTest {

    @Test
    public void test() {
        assertEquals(newSet("AAAAACCCCC", "CCCCCAAAAA"), newSet(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));

        assertEquals(newSet("AAAAACCCCC", "CCCCCAAAAA"), newSet(findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) return result;

        Map<Integer, Integer> countNumber = new HashMap<>();
        //from 0 -9
        int curNumber = 0;
        for (int i = 0; i <= 9; ++i) {
            curNumber |= charToNumber(s.charAt(i)) << (i * 2);
        }
        countNumber.put(curNumber, 1);

        final char[] found = new char[10];
        final char[] numberToChar = new char[]{'A', 'C', 'G', 'T'};

        for (int i = 10; i < s.length(); ++i) {
            curNumber >>= 2;  //remove before char
            curNumber |= charToNumber(s.charAt(i)) << 18; // the highest 2 bits
            Integer count = countNumber.get(curNumber);
            if (count == null) {
                countNumber.put(curNumber, 1);
            } else if (count == 1) {
                countNumber.put(curNumber, 2);
                // find one
                int foundNumber = curNumber;
                for (int j = 0; j < found.length; ++j) {
                    found[j] = numberToChar[foundNumber & 3];
                    foundNumber >>= 2;
                }
                result.add(new String(found));
            }
        }

        return result;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) return result;

        Map<Integer, Integer> countNumber = new HashMap<>();
        //from 0 -9
        int curNumber = 0;
        for (int i = 0; i <= 9; ++i) {
            curNumber |= charToNumber(s.charAt(i)) << (i * 2);
        }
        countNumber.put(curNumber, 1);

        for (int i = 10; i < s.length(); ++i) {
            curNumber >>= 2;  //remove before char
            curNumber |= charToNumber(s.charAt(i)) << 18; // the highest 2 bits
            Integer count = countNumber.get(curNumber);
            if (count == null) {
                countNumber.put(curNumber, 1);
            } else if (count == 1) {
                countNumber.put(curNumber, 2);
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }

    private int charToNumber(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3;
    }
}
