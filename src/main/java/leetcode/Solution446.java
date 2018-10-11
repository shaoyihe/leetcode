package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
 *  446. Arithmetic Slices II - Subsequence
 * </pre>
 * on 2018/09/08.
 */
public class Solution446 extends BaseTest {

    @Test
    public void test() {
        assertEquals(7, numberOfArithmeticSlices(arr(2, 4, 6, 8, 10)));
        assertEquals(4, numberOfArithmeticSlices(arr(0, 1, 2, 2, 2)));
        assertEquals(0, numberOfArithmeticSlices(arr(0, 2000000000, -294967296)));
        assertEquals(16, numberOfArithmeticSlices(arr(1, 1, 1, 1, 1)));
    }


    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;

        Map<Long, List<Integer>> valToIndex = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            valToIndex.computeIfAbsent((long) A[i], (none) -> new ArrayList<>()).add(i);
        }

        int result = 0;
        boolean[][] found = new boolean[A.length][A.length];
        for (int i = 0; i < A.length - 2; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (!found[i][j])
                    result += iter(A, i, j, found, valToIndex, 1);
            }
        }
        return result;
    }


    private int iter(int[] A, int firstIndex, int secondIndex, boolean[][] found, Map<Long, List<Integer>> valToIndex, int depth) {
        found[firstIndex][secondIndex] = true;

        int result = 0;
        List<Integer> poses = valToIndex.get((long) A[secondIndex] + A[secondIndex] - A[firstIndex]);
        if (poses != null) {
            for (int i = poses.size() - 1; i >= 0 && poses.get(i) > secondIndex; --i) {
                result += depth;
                result += iter(A, secondIndex, poses.get(i), found, valToIndex, depth + 1);
            }
        }
        return result;
    }

    private int compute(int total) {
        if (total >= 3) {
            return (total - 2);
        }
        return 0;
    }

}
