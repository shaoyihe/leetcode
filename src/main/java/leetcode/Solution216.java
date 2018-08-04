package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/combination-sum-iii/description/
 *  216. Combination Sum III
 * </pre>
 * on 2018/8/2.
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution11 = new Solution216();
        System.err.println(solution11.combinationSum3(3, 9));
    }


    public List<List<Integer>> combinationSum3(int k, int target) {
        if (k <= 0 || target < 1) return Collections.emptyList();

        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        loop(result, new ArrayList<>(), 0, candidates, target, k);
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> list, int index, int[] candidates, int target, int k) {
        if (index < candidates.length) {
            int candidate = candidates[index];
            if (target == candidate) {
                if (list.size() == k - 1) result.add(addNum(list, candidate));
            } else if (target > candidate && list.size() < k && list.size() + (candidates.length - index) >= k) {
                // 1 index
                loop(result, addNum(new ArrayList<>(list), candidate), index + 1, candidates, target - candidate, k);

                //0 index
                loop(result, list, index + 1, candidates, target, k);
            }
        }
    }

    private List<Integer> addNum(List<Integer> list, int num) {
        list.add(num);
        return list;
    }

}
