package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     https://leetcode.com/problems/132-pattern/submissions/
 *     132 Pattern
 *    </pre>
 */
public class Solution456 {

    @Test
    public void test() {
//        Assert.assertTrue(find132pattern(new int[]{8, 10, 4, 6, 5}));
//        Assert.assertTrue(find132pattern(new int[]{4, 1, 3, 2}));
        Assert.assertFalse(find132pattern(new int[]{1, 0, 1, -4, -3}));
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        List<int[]> result = new ArrayList<>();
        int resultSize = 0;

        int min = nums[0];
        boolean minIsnull = false;
        for (int i = 1; i < nums.length; ++i) {
            int curNum = nums[i];
            int status = 0;
            for (int j = 0; j < resultSize; ++j) {
                int[] cur = result.get(j);
                if (curNum == cur[0] || curNum == cur[1] || curNum < cur[0]) {
                    if (j == resultSize - 1) {
                        status = 2;
                    }
                    continue;
                }
                if (curNum > cur[1]) {
                    //merge
                    cur[1] = curNum;
                    cur[0] = result.get(resultSize - 1)[0];
                    //delete
                    resultSize = j + 1;
                    break;

                } else {
                    //found
                    status = 1;
                    break;
                }

            }

            if (status == 1) {
                return true;
            }

            if (resultSize == 0 || status == 2) {
                if (minIsnull || curNum <= min) {
                    min = curNum;
                    minIsnull = false;
                } else {
                    result.add(resultSize++, new int[]{min, curNum});
                    minIsnull = true;
                }
            }
        }

        return false;
    }
}
