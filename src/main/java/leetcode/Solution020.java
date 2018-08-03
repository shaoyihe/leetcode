package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/palindrome-number
 * 9. Palindrome Number
 * </pre>
 * on 2018/8/2.
 */
public class Solution020 {
    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        System.err.println(solution020.isValid("()[]{}")); //true
        System.err.println(solution020.isValid("([))")); //false
    }

    public boolean isValid(String s) {
        if (s == null) return false;
        char[] sChar = s.toCharArray();
        if (sChar.length == 0) return true;
        if (sChar.length % 2 != 0) return false;
        return isValid(sChar, 0, sChar.length - 1);
    }

    private boolean isValid(char[] sChar, int from, int to) {
        if (from > to) return true;
        if (from == to) return false;
        int left = (to - from + 1) / 2 - 1 + from, right = (to - from + 1) / 2 + from;
        for (; left >= from && right <= to && isPair(sChar, left, right); --left, ++right) ;
        return isValid(sChar, from, left) && isValid(sChar, right, to);

    }

    private boolean isPair(char[] sChar, int left, int right) {
        return (sChar[left] == '(' && sChar[right] == ')') ||
                (sChar[left] == '{' && sChar[right] == '}') ||
                (sChar[left] == '[' && sChar[right] == ']');
    }

}
