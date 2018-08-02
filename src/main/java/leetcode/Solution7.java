package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/reverse-integer
 * 7. Reverse Integer
 * </pre>
 * on 2018/8/2.
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution5 = new Solution7();
        System.err.println(solution5.reverse(1534236469));
    }

    public int reverse(int x) {
        long result = 0;
        for (; x != 0; x /= 10) {
            result = result * 10 + x % 10;
        }
        return (int) result != result ? 0 : (int) result;
    }
}
