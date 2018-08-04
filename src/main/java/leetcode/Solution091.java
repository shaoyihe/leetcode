package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/decode-ways
 *  91. Decode Ways
 * </pre>
 * on 2018/8/2.
 */
public class Solution091 {
    public static void main(String[] args) {
        Solution091 solution11 = new Solution091();
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.err.println(solution11.numDecodings("1"));
        System.err.println(solution11.numDecodings("111"));
        System.err.println(solution11.numDecodings("10"));
        System.err.println(solution11.numDecodings("120"));
        System.err.println(solution11.numDecodings("12345"));
        System.err.println(solution11.numDecodings("226"));

        System.err.println(solution11.numDecodings2("1"));
        System.err.println(solution11.numDecodings2("111"));
        System.err.println(solution11.numDecodings2("10"));
        System.err.println(solution11.numDecodings2("120"));
        System.err.println(solution11.numDecodings2("12345"));
        System.err.println(solution11.numDecodings2("226"));
    }


    /**
     * 4%
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        return loop(s.toCharArray(), 0);
    }

    private int loop(char[] sChar, int from) {
        if (from > sChar.length - 1) {
            return 1;
        } else if (sChar[from] == '0') {
            return 0;
        } else {
            if (from + 1 < sChar.length && (sChar[from] == '1' || (sChar[from] == '2' && sChar[from + 1] <= '6'))) {
                return loop(sChar, from + 1) + loop(sChar, from + 2);
            } else {
                return loop(sChar, from + 1);
            }
        }
    }


    /**
     * 64%
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        return loop2(s.toCharArray(), 0, new HashMap<>());
    }

    private int loop2(char[] sChar, int from, Map<Integer, Integer> cache) {
        Integer result = cache.get(from);
        if (result != null) return result;
        if (from > sChar.length - 1) {
            result = 1;
        } else if (sChar[from] == '0') {
            result = 0;
        } else {
            if (from + 1 < sChar.length && (sChar[from] == '1' || (sChar[from] == '2' && sChar[from + 1] <= '6'))) {
                result = loop2(sChar, from + 1, cache) + loop2(sChar, from + 2, cache);
            } else {
                result = loop2(sChar, from + 1, cache);
            }
        }
        cache.put(from, result);
        return result;
    }

}
