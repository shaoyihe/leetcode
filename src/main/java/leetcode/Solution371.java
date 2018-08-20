package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/container-with-most-water
 *  11. Container With Most Water
 * </pre>
 * on 2018/8/2.
 */
public class Solution371 {
    public static void main(String[] args) {
        Solution371 solution11 = new Solution371();
        //49
    }

    public int getSum(int a, int b) {
        int result = 0;
        for (int carryBit = 0; a > 0 || b > 0; a >>>= 1, b >>>= 1) {
            int ab = (a & 1) & (b & 1);
            if (ab == 0) {

            }
        }
        return result;
    }
}
