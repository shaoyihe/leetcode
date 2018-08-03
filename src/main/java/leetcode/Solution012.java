package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/integer-to-roman/description/
 *  12. Integer to Roman
 * </pre>
 * on 2018/8/2.
 */
public class Solution012 {
    public static void main(String[] args) {
        Solution012 solution11 = new Solution012();
        System.err.println(solution11.intToRoman(1994));
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; num > 0; ++i) {
            int baseNum = values[i];
            if (num >= baseNum) {
                int repeatTime = num / baseNum;
                num -= repeatTime * baseNum;
                String symbol = strs[i];
                for (int j = 0; j < repeatTime; ++j) result.append(symbol);
            }
        }
        return result.toString();
    }

}
