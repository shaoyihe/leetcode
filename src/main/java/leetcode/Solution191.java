package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/number-of-1-bits/description/
 *  191. Number of 1 Bits
 * </pre>
 * on 2018/8/2.
 */
public class Solution191 {
    public static void main(String[] args) {
        Solution191 solution11 = new Solution191();
        System.err.println(solution11.hammingWeight(64));
        System.err.println(solution11.hammingWeight(64));
    }

    public int hammingWeight(int n) {
        if (n == 0) return 0;
        return (n & 1) + hammingWeight(n >>> 1);
    }

}
