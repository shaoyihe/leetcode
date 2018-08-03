package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *  17. Letter Combinations of a Phone Number
 * </pre>
 * on 2018/8/2.
 */
public class Solution017 {
    public static void main(String[] args) {
        Solution017 solution11 = new Solution017();
        System.err.println(solution11.letterCombinations("27"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        int length = digits.length();
        int[] base = new int[length];
        int[] loopTimes = new int[length];
        for (int i = 0; i < length; ++i) {
            int number = digits.charAt(i) - '0';
            base[i] = base(number);
            loopTimes[i] = (number == 7 || number == 9) ? 4 : 3;
        }

        List<String> result = new ArrayList<>((int) Math.pow(3, length));
        loop(new char[length], length, 0, base, result, loopTimes);
        return result;
    }

    private int base(int number) {
        return ((number - 2) * 3 + (int) 'a') + (number > 7 ? 1 : 0);
    }

    private void loop(char[] resultChar, int totalLength, int index, int[] base, List<String> result, int[] loopTimes) {
        if (index == totalLength) {
            result.add(new String(resultChar));
        } else {
            int loopTime = loopTimes[index];
            int baseVal = base[index];
            for (int i = 0; i < loopTime; ++i) {
                char[] chars = (i == loopTime - 1) ? resultChar : copyOf(resultChar, totalLength, index + 1);
                chars[index] = (char) (baseVal + i);
                loop(chars, totalLength, index + 1, base, result, loopTimes);
            }
        }
    }

    private char[] copyOf(char[] original, int newLength, int copyLength) {
        char[] copy = new char[newLength];
        System.arraycopy(original, 0, copy, 0, copyLength);
        return copy;
    }

}
