package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *  https://leetcode.com/problems/range-sum-query-immutable/description/
 *  303. Range Sum Query - Immutable
 * </pre>
 * on 2018/8/27.
 */
public class Solution303 extends BaseTest {

    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));

        NumArray2 numArray2 = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, numArray2.sumRange(0, 2));
        assertEquals(-1, numArray2.sumRange(2, 5));
        assertEquals(-3, numArray2.sumRange(0, 5));


        NumArray3 numArray3 = new NumArray3(new int[]{-2, 0, 3, -5, 2, -1});
        assertEquals(1, numArray3.sumRange(0, 2));
        assertEquals(-1, numArray3.sumRange(2, 5));
        assertEquals(-3, numArray3.sumRange(0, 5));
    }

    class NumArray {

        private int[] nums;
        private Integer[][] sumNums;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sumNums = new Integer[nums.length][nums.length];
        }

        public int sumRange(int i, int j) {
            return innerSumRange(Math.max(0, i), Math.min(j, nums.length - 1));
        }

        private int innerSumRange(int i, int j) {
            if (i == j) return nums[i];
            if (sumNums[i][j] != null) return sumNums[i][j];
            return sumNums[i][j] = nums[i] + innerSumRange(i + 1, j);
        }
    }

    class NumArray2 {

        private int[] nums;
        private Integer[][] sumNums;

        public NumArray2(int[] nums) {
            this.nums = nums;
            this.sumNums = new Integer[nums.length][nums.length];
        }

        public int sumRange(int i, int j) {
            i = Math.max(0, i);
            j = Math.min(j, nums.length - 1);

            int result = 0;
            for (int localFrom = i; i <= j; ++i) {
                if (sumNums[i][j] != null) {
                    result += sumNums[i][j];
                    break;
                }
                result += nums[i];
                sumNums[localFrom][i] = result;
            }
            return result;
        }
    }

    class NumArray3 {

        private int[] nums;
        private Map<Integer, Integer>[] sumNums;

        public NumArray3(int[] nums) {
            this.nums = nums;
            this.sumNums = new HashMap[nums.length];
        }

        public int sumRange(int i, int j) {
            i = Math.max(0, i);
            j = Math.min(j, nums.length - 1);

            Map<Integer, Integer> iToResult = sumNums[i];
            if (iToResult == null) iToResult = sumNums[i] = new HashMap<>();

            int result = 0;
            for (; i <= j; ++i) {
                Integer curResult = iToResult.get(j);
                if (curResult != null) {
                    result += curResult;
                    break;
                }
                result += nums[i];
                iToResult.put(i, result);
            }
            return result;
        }

    }


    class NumArray4 {

        private int[] nums;
        private Integer[][] sumNums;
        private final int finalNumber = 10;
        private final int[] toNumber = new int[finalNumber];

        public NumArray4(int[] nums) {
            this.nums = nums;
            this.sumNums = new Integer[finalNumber][nums.length];

            for (int i = 0; i < finalNumber; ++i) {
                toNumber[i] = 1 << (i + 2);
            }
        }

        public int sumRange(int i, int j) {
            return innerSumRange(Math.max(0, i), Math.min(j, nums.length - 1), finalNumber - 1);
        }

        private int innerSumRange(int i, int j, int toIndex) {
            if (i < j) return 0;
            if (i == j) return nums[i];

            for (int from = toIndex; from >= 0; ++from) {

            }

            //todo
            return 0;
        }

    }

}
