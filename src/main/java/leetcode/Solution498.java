package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/diagonal-traverse/description/
 *  498. Diagonal Traverse
 * </pre>
 * on 2018/9/21.
 */
public class Solution498 extends BaseTest {

    @Test
    public void test() {

    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int[] result = new int[matrix.length * matrix[0].length];
        int resultIndex = 0, round = 0, from = 0;
        for (int i = 0; i < matrix[0].length; ++i) {
            ++round;
            from = resultIndex;
            result[resultIndex++] = matrix[0][i];
            for (int column = i - 1, row = 1; column >= 0 && row < matrix.length; --column, ++row) {
                result[resultIndex++] = matrix[row][column];
            }
            if (round % 2 == 1) reverse(result, from, resultIndex - 1);
        }
        for (int j = 1; j < matrix.length; ++j) {
            ++round;
            from = resultIndex;
            result[resultIndex++] = matrix[j][matrix[0].length - 1];
            for (int column = matrix[0].length - 2, row = j + 1; column >= 0 && row < matrix.length; --column, ++row) {
                result[resultIndex++] = matrix[row][column];
            }
            if (round % 2 == 1) reverse(result, from, resultIndex - 1);
        }
        return result;
    }

    private void reverse(int[] result, int from, int to) {
        for (; from < to; ++from, --to) {
            int temp = result[from];
            result[from] = result[to];
            result[to] = temp;
        }
    }

}
