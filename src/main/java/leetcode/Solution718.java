package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *  718. Maximum Length of Repeated Subarray
 * </pre>
 * on 2018/10/08.
 */
public class Solution718 extends BaseTest {

    @Test
    public void test() {
        assertEquals(3, findLength(arr(1, 2, 3, 2, 1), arr(3, 2, 1, 4, 7)));
        assertEquals(2, findLength(arr(0, 1, 1, 1, 1), arr(1, 0, 1, 0, 1)));
    }

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; ++i) {
            List<Integer> list = map.computeIfAbsent(A[i], k -> new ArrayList<>());
            list.add(i);
        }

        int max = 0;
        for (int i = 0; i < B.length - max; ++i) {
            List<Integer> list = map.get(B[i]);
            if (list != null) {
                for (Integer pos : list) {
                    max = Math.max(max, findLength(A, B, pos + 1, i + 1) + 1);
                }
            }
        }
        return max;
    }

    private int findLength(int[] A, int[] B, int fromA, int fromB) {
        int length = 0;
        for (; fromA < A.length && fromB < B.length && A[fromA] == B[fromB]; fromA++, fromB++) length++;
        return length;
    }

}
