package leetcode;

import leetcode.util.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *  646. Maximum Length of Pair Chain
 * </pre>
 * on 2018/9/26.
 */
public class Solution491 extends BaseTest {

    @Test
    public void test() {

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) return new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();

        Set<List<Integer>> temp = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            for (List<Integer> curIntegers : result) {
                if (curIntegers.get(curIntegers.size() - 1) <= nums[i]) {
                    List<Integer> clone = (List<Integer>) ((ArrayList) curIntegers).clone();
                    clone.add(nums[i]);
                    temp.add(clone);
                }
            }
            result.addAll(temp);
            temp.clear();

            for (int j = 0; j < i; ++j) {
                if (nums[j] <= nums[i]) {
                    result.add(addTo(nums[j], nums[i]));
                }
            }
        }
        return new ArrayList<>(result);
    }

    private List<Integer> addTo(int a, int b) {
        List<Integer> cur = new ArrayList<>();
        cur.add(a);
        cur.add(b);
        return cur;
    }

}
