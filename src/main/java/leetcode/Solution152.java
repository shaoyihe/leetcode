package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/merge-sorted-array/description/
 *  88. Merge Sorted Array
 * </pre>
 * on 2018/8/2.
 */
public class Solution152 {
    public static void main(String[] args) {
        Solution152 solution11 = new Solution152();
        System.err.println(solution11.maxProduct(new int[]{2, 3, -2, 4}));
        System.err.println(solution11.maxProduct(new int[]{-2, 0, -1}));
        System.err.println(solution11.maxProduct(new int[]{0, 1, 1, -3}));
        System.err.println(solution11.maxProduct(new int[]{-2, 0, -1}));
    }


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        int[] countNegative = new int[nums.length];
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                i++;
                max = Math.max(max, 0);
                continue;
            }

            int index = i;
            long product = 1;
            for (; index < nums.length && nums[index] != 0; ++index) {
                countNegative[index] = (index == 0 ? 0 : countNegative[index - 1]) + (nums[index] < 0 ? 1 : 0);
                product *= nums[index];
            }

            if (countNegative[index - 1] % 2 == 0) {
                max = Math.max(max, (int) product);
            } else {
                for (int j = i, countN = 0, leftProduct = 1; j < index; ++j) {
                    if (nums[j] < 0) {
                        if (countN++ % 2 == 0) {
                            if (j == i) {
                                if (j != index - 1) {
                                    max = (int) Math.max(max, product / nums[j]);
                                } else {
                                    max = (int) Math.max(max, nums[j]);
                                }
                            } else {
                                max = Math.max(max, leftProduct);
                                if (j != index - 1) {
                                    max = (int) Math.max(product / leftProduct / nums[j], max);
                                }
                            }
                        }
                    }
                    leftProduct *= nums[j];
                }
            }
            i = index;
        }

        return max;
    }

}
