package leetcode;

import java.util.Arrays;

/**
 * <pre>
 *  https://leetcode.com/problems/first-bad-version/description/
 *  278. First Bad Version
 * </pre>
 * on 2018/8/2.
 */
public class Solution031 {
    public static void main(String[] args) {
        Solution031 solution11 = new Solution031();
        int[] arr = {1, 5, 1};
        solution11.nextPermutation(arr);
        System.err.println(Arrays.toString(arr));
    }


    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = nums.length - 2, lastMaxVal = nums[nums.length - 1]; i >= 0; --i) {
            int num = nums[i];
            if (num < lastMaxVal) {
                //found
                Arrays.sort(nums, i + 1, nums.length);

                //find first bigger than num
                int foundIndex = i + 1;
                for (int from = i + 1, to = nums.length - 1; from <= to; ) {
                    int middleIndex = (from + to) / 2;
                    int middleVal = nums[middleIndex];
                    if (middleVal <= num) {
                        from = middleIndex + 1;
                    } else {
                        if (middleIndex == i + 1 || nums[middleIndex - 1] <= num) {
                            foundIndex = middleIndex;
                            break;
                        } else {
                            to = middleIndex - 1;
                        }
                    }
                }
                swap(nums, i, foundIndex);
                // foundIndex left
                for (; foundIndex - 1 > i && nums[foundIndex - 1] > nums[foundIndex]; ) {
                    swap(nums, foundIndex - 1, foundIndex);
                    --foundIndex;
                }

                return;
            } else {
                lastMaxVal = num;
            }
        }

        Arrays.sort(nums);
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

}
