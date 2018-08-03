package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/roman-to-integer/description/
 *  13. Roman to Integer
 * </pre>
 * on 2018/8/2.
 */
public class Solution013 {
    public static void main(String[] args) {
        Solution013 solution11 = new Solution013();
        System.err.println(solution11.romanToInt("DCXXI"));
    }

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        char[] cArr = s.toCharArray();
        for (int i = 0, valIndex = 0; i < cArr.length; ) {
            String val = strs[valIndex];
            if (cArr[i] == val.charAt(0)) {
                if (val.length() == 2) {
                    if (i + 1 < cArr.length && val.charAt(1) == cArr[i + 1]) {
                        i += 2;
                        result += values[valIndex];
                    } else {
                        ++valIndex;
                    }
                } else {
                    result += values[valIndex];
                    ++i;
                }
            } else {
                ++valIndex;
            }
        }
        return result;
    }

}
