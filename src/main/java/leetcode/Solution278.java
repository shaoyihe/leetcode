package leetcode;

/**
 * <pre>
 *  https://leetcode.com/problems/first-bad-version/description/
 *  278. First Bad Version
 * </pre>
 * on 2018/8/2.
 */
public class Solution278 {
    public static void main(String[] args) {
        Solution278 solution11 = new Solution278();
        int[] arr = {1};
        System.err.println(solution11.firstBadVersion(5));
    }


    public int firstBadVersion(int n) {
        if (n < 0) throw new RuntimeException();

        int right = -1;
        for (int from = 1, to = n; from <= to; ) {
            int middle = from + (to - from) / 2;
            if (isBadVersion(middle)) {
                right = middle;
                to = middle - 1;
            } else {
                from = middle + 1;
            }
        }
        // not should
        return right;
    }

    boolean isBadVersion(int version) {
        return version >= 4;
    }
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

}
