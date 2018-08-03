package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/median-of-two-sorted-arrays
 *  4. Median of Two Sorted Arrays
 * </pre>
 * on 2018/8/2.
 */
public class Solution004 {
    public static void main(String[] args) {
        Solution004 solution3 = new Solution004();
        assert solution3.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
        assert solution3.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5;
        assert solution3.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{}) == 2.5;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] orders;
        if (totalLength % 2 == 0) {
            orders = new int[]{totalLength / 2, totalLength / 2 + 1};
        } else {
            orders = new int[]{totalLength / 2 + 1};
        }

        int[] result = new int[orders.length];
        for (int orderIndex = 0, order = 1, num1Index = 0, num2Index = 0; orderIndex < orders.length; ++order) {
            int orderVal;
            if (num2Index >= nums2.length || (num1Index < nums1.length && nums1[num1Index] <= nums2[num2Index])) {
                orderVal = nums1[num1Index++];
            } else {
                orderVal = nums2[num2Index++];
            }
            if (order == orders[orderIndex]) {
                result[orderIndex++] = orderVal;
            }
        }
        return result.length == 1 ? result[0] : ((double) result[0] + result[1]) / 2;
    }
}
