package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/first-bad-version/description/
 *  278. First Bad Version
 * </pre>
 * on 2018/8/2.
 */
public class Solution029 {
    public static void main(String[] args) {
        Solution029 solution11 = new Solution029();
        int[] arr = {1};
        System.err.println(solution11.divide(7, -3));
    }


    public int divide(int dividend, int divisor) {
        long absDividend = Math.abs((long) dividend), absDivisor = Math.abs((long) divisor);
        if (absDivisor > absDividend) return 0;

        long result = 1;

        List<Long> divide = new ArrayList<>();
        divide.add(1L);

        List<Long> base = new ArrayList<>();
        base.add(absDivisor);

        for (; ; ) {
            if (absDivisor + absDivisor <= absDividend) {
                absDivisor += absDivisor;
                result += result;

                divide.add(result);
                base.add(absDivisor);
            } else if (absDivisor + base.get(0) <= absDividend) {
                for (int i = base.size() - 1; i >= 0; ) {
                    if (absDivisor + base.get(i) <= absDividend) {
                        absDivisor += base.get(i);
                        result += divide.get(i);
                    } else {
                        --i;
                    }
                }
                break;
            } else {
                break;
            }
        }

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            if (-result != (int) -result) return Integer.MAX_VALUE;
            return (int) -result;
        } else {
            if (result != (int) result) return Integer.MAX_VALUE;
            return (int) result;
        }
    }

}
