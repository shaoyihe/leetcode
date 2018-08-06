package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/unique-paths/description/
 *  62. Unique Paths
 * </pre>
 * on 2018/8/2.
 */
public class Solution062 {
    public static void main(String[] args) {
        Solution062 solution11 = new Solution062();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.err.println(solution11.uniquePaths(3, 2));
        System.err.println(solution11.uniquePaths(7, 3));
        System.err.println(solution11.uniquePaths2(3, 2));
        System.err.println(solution11.uniquePaths2(7, 3));
        System.err.println(solution11.uniquePaths2(23, 12));
    }

    /**
     * time out
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[n][m];
        loop(cache, 0, 0, n, m);
        return cache[n - 1][m - 1];
    }

    private void loop(int[][] cache, int row, int column, int rowLength, int columnLength) {
        if (row != rowLength && column != columnLength) {
            cache[row][column]++;
            loop(cache, row + 1, column, rowLength, columnLength);
            loop(cache, row, column + 1, rowLength, columnLength);
        }
    }

    public int uniquePaths2(int m, int n) {
        int[][] cache = new int[n][m];
        cache[0][0] = 1;
        loop2(cache, n - 1, m - 1, n, m);
        return cache[n - 1][m - 1];
    }

    private int loop2(int[][] cache, int row, int column, int rowLength, int columnLength) {
        if (row < 0 || column < 0) {
            return 0;
        }
        if (cache[row][column] > 0) return cache[row][column];
        return cache[row][column] = loop2(cache, row - 1, column, rowLength, columnLength) + loop2(cache, row, column - 1, rowLength, columnLength);
    }
}
