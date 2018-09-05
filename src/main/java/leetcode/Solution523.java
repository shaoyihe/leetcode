package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/continuous-subarray-sum/description/
 *  523. Continuous Subarray Sum
 * </pre>
 * on 2018/09/03.
 */
public class Solution523 extends BaseTest {

    @Test
    public void test() {
        assertTrue(checkSubarraySum(arr(23, 2, 4, 6, 7), 6));
        assertTrue(checkSubarraySum(arr(23, 2, 4, 6, 7), -6));
        assertTrue(checkSubarraySum(arr(0, 0), 0));
        assertTrue(checkSubarraySum(arr(1, 2, 3), 5));
        assertFalse(checkSubarraySum(arr(1, 2, 3), 4));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        if (k == 0) {
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == 0 && nums[i - 1] == 0) return true;
            }
            return false;
        }

        if (k < 0) k = -k;
        Map<Integer, Integer> modValueFrom0ToPos = new HashMap<>();
        int[] sumValFrom0 = new int[nums.length];
        sumValFrom0[0] = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            sumValFrom0[i] = sumValFrom0[i - 1] + nums[i];
            int modValueFrom0 = sumValFrom0[i] % k;
            if (modValueFrom0 == 0) return true;
            modValueFrom0ToPos.put(modValueFrom0, i);
        }
        for (int i = 0; i < nums.length; ++i) {
            Integer modPos = modValueFrom0ToPos.get(k - (sumValFrom0[i] % k));
            if (modPos != null && modPos > i + 1) return true;

            modPos = modValueFrom0ToPos.get(sumValFrom0[i] % k);
            if (modPos != null && modPos > i + 1 && (sumValFrom0[modPos] - sumValFrom0[i]) % k == 0) return true;
        }
        return false;
    }

}
