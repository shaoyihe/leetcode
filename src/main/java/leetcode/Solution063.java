package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/unique-paths-ii/description/
 *  63. Unique Paths II
 * </pre>
 * on 2018/8/2.
 */
public class Solution063 {
    public static void main(String[] args) {
        Solution063 solution11 = new Solution063();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] cache = new int[row][column];
        for (int i = 0; i < row; ++i) Arrays.fill(cache[i], -1);
        cache[0][0] = 1;
        loop(obstacleGrid, cache, row - 1, column - 1, row, column);
        return cache[row - 1][column - 1];
    }

    private int loop(int[][] obstacleGrid, int[][] cache, int row, int column, int rowLength, int columnLength) {
        if (row < 0 || column < 0) {
            return 0;
        } else if (obstacleGrid[row][column] == 1) {
            return cache[row][column] = 0;
        }
        if (cache[row][column] >= 0) return cache[row][column];
        return cache[row][column] = loop(obstacleGrid, cache, row - 1, column, rowLength, columnLength) + loop(obstacleGrid, cache, row, column - 1, rowLength, columnLength);
    }
}
