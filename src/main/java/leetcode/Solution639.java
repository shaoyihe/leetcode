package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/decode-ways-ii/
 *  639. Decode Ways II
 * </pre>
 * on 2018/8/2.
 */
public class Solution639 {
    public static void main(String[] args) {
        Solution639 solution11 = new Solution639();
        int[] arr = {1, 1, 1, 2, 2, 3};

        System.err.println(solution11.numDecodings("1*"));
    }


    /**
     * 64%
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        return (int) ((loop2(s.toCharArray(), 0, new HashMap<>())) % ((int) Math.pow(10, 9) + 7));
    }

    private long loop2(char[] sChar, int from, Map<Integer, Long> cache) {
        Long result = cache.get(from);
        if (result != null) return result;
        if (from > sChar.length - 1) {
            result = 1L;
        } else if (sChar[from] == '0') {
            result = 0L;
        } else {
            result = (sChar[from] == '*' ? 9 : 1) * loop2(sChar, from + 1, cache);
            if (from + 1 < sChar.length) {
                if (sChar[from] == '*') {
                    if (sChar[from + 1] == '*') {
                        result += 15 * loop2(sChar, from + 2, cache);
                    } else {
                        result += (9 + (sChar[from + 1] <= '6' ? 1 : 0)) * loop2(sChar, from + 2, cache);
                    }
                } else if (sChar[from] == '1') {
                    result += (sChar[from + 1] == '*' ? 9 : 1) * loop2(sChar, from + 2, cache);
                } else if (sChar[from] == '2') {
                    result += (sChar[from + 1] == '*' ? 6 : 1) * loop2(sChar, from + 2, cache);
                }

            }
        }
        cache.put(from, result);
        return result;
    }

}
