package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/regular-expression-matching/description/
 * 10. Regular Expression Matching
 * </pre>
 * on 2018/8/2.
 */
public class Solution010 {
    private final char NOT_EXIST = '0';
    private char[] sChar;
    private char[] pChar;
    private int pIndex = 0;
    private int sIndex = 0;
    private boolean inLoopCousmer = false;
    private char inLoopCousmerChar;

    public static void main(String[] args) {
        Solution010 solution52 = new Solution010();
//        System.err.println(solution5.isMatch("aab", "c*a*b"));
    }

    /**
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        this.sChar = s.toCharArray();
        this.pChar = p.toCharArray();
        while (consumeNext()) ;
        return pIndex == pChar.length - 1 && sIndex == sChar.length - 1;
    }

    private boolean consumeNext() {
        char c = sChar[sIndex];
        char p = inLoopCousmer ? inLoopCousmerChar : pChar[pIndex];
        if (p == '*') {
            inLoopCousmer = true;
            inLoopCousmerChar = pChar[pIndex - 1];
            return consumeNext();
        }

        if (p == '.' || c == p) {
            //success
            sIndex++;
            pIndex++;
        } else {
            char nextP = nextPChar();
            if (nextP == '*') {
                //ignore curr
                sIndex++;
                pIndex += 2;
            } else if (nextP == NOT_EXIST) {
                return false;
            } else {
                inLoopCousmer = false;
                ++pIndex;
                return consumeNext();
            }
        }
        return sIndex < sChar.length;
    }

    private char nextPChar() {
        if (pIndex < pChar.length - 1) return pChar[pIndex + 1];
        return NOT_EXIST;
    }

}
