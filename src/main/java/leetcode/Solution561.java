package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/array-partition-i/description/
 *  561. Array Partition I
 * </pre>
 * on 2018/8/27.
 */
public class Solution561 extends BaseTest {

    @Test
    public void test() {
        assertEquals(4, arrayPairSum(arr(1, 4, 3, 2)));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
