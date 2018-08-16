package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 *  https://leetcode.com/problems/majority-element/description/
 * 169. Majority Element
 * </pre>
 * on 2018/8/15.
 */
public class Solution169 {

    @Test
    public void test() {
        Assert.assertEquals(3, majorityElement(new int[]{3, 3, 4}));
        Assert.assertEquals(3, majorityElement(new int[]{3, 2, 3}));
        Assert.assertEquals(2, majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * same as quick sort
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        //the n/2 biggest element
        int targetPos = nums.length / 2 ;

        for (int from = 0, to = nums.length - 1; ; ) {
            int middle = (from + to) / 2;
            int middleValue = middleVal(nums[from], nums[to], nums[middle]);
            //sort
            int middleValIndex = from;
            for (int j = to; middleValIndex < j; ) {
                for (; nums[middleValIndex] < middleValue; ++middleValIndex) ;
                for (; nums[j] >= middleValue && middleValIndex < j; --j) ;
                if (middleValIndex < j) {
                    swap(middleValIndex++, j--, nums);
                }
            }
            if (nums[targetPos] == nums[middleValIndex]) return nums[targetPos];
            if (middleValIndex < targetPos) {
                from = middleValIndex + 1;
            } else {
                to = middleValIndex - 1;
            }
        }
    }

    private void swap(int one, int two, int[] nums) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }

    private int middleVal(int one, int two, int three) {
        if (one >= two) {
            return three >= one ? one : Math.max(three, two);
        } else {
            return three >= two ? two : Math.max(three, one);
        }
    }
}
