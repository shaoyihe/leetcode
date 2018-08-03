package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/palindrome-number
 * 9. Palindrome Number
 * </pre>
 * on 2018/8/2.
 */
public class Solution009 {
    public static void main(String[] args) {
        Solution009 solution5 = new Solution009();
        System.err.println(solution5.isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        return x == reverse(x);
    }

    private int reverse(int x) {
        long result = 0;
        for (; x != 0; x /= 10) {
            result = result * 10 + x % 10;
        }
        return (int) result != result ? 0 : (int) result;
    }

}
