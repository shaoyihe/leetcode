package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/valid-sudoku/description/
 *  36. Valid Sudoku
 * </pre>
 * on 2018/8/2.
 */
public class Solution036 {
    public static void main(String[] args) {
    }

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], column = new int[9], subBoxes = new int[9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.') {
                    //row check
                    int cInt = 2 << (c - '0');
                    if (check(row, i, cInt) && check(column, j, cInt) && check(subBoxes, i / 3 * 3 + j / 3, cInt)) {
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean check(int[] check, int index, int val) {
        if ((check[index] & val) > 0) {
            return false;
        }
        check[index] |= val;
        return true;
    }
}
