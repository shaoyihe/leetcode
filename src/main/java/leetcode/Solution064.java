package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/plus-one/description/
 *  66. Plus One
 * </pre>
 * on 2018/8/2.
 */
public class Solution064 {
    public static void main(String[] args) {
        Solution064 solution11 = new Solution064();
        int[][] result = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.err.println(solution11.minPathSum(result));
        System.err.println(solution11.minPathSum2(result));
    }


    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        return (int) loop(grid, grid.length, grid[0].length, 0, 0);
    }

    private long loop(int[][] grid, int rowLength, int columnLength, int row, int column) {
        if (row == rowLength - 1 && column == columnLength - 1) {
            return grid[row][column];
        }

        if (row == rowLength || column == columnLength) {
            return Integer.MAX_VALUE;
        }
        //
        return (long) grid[row][column] + Math.min(loop(grid, rowLength, columnLength, row + 1, column),
                loop(grid, rowLength, columnLength, row, column + 1));
    }


    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int[][] minFillVal = new int[grid.length][grid[0].length];
        loop(grid, 0, 0, 0, minFillVal);
        return minFillVal[grid.length - 1][grid[0].length - 1];
    }

    private void loop(int[][] grid, int row, int column, int lastVal, int[][] minFillVal) {
        if (row == grid.length || column == grid[0].length) {
            return;
        }

        int minVal = minFillVal[row][column];
        int curVal = lastVal + grid[row][column];
        if (minVal == 0 || curVal < minVal) {
            minFillVal[row][column] = curVal;
            loop(grid, row + 1, column, curVal, minFillVal);
            loop(grid, row, column + 1, curVal, minFillVal);
        }
    }

}
