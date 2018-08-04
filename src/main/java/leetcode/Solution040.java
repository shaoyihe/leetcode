package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/combination-sum-ii/description/
 *  40. Combination Sum II
 * </pre>
 * on 2018/8/2.
 */
public class Solution040 {
    public static void main(String[] args) {
        Solution040 solution11 = new Solution040();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.err.println(solution11.combinationSum2(arr, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        loop(result, new ArrayList<>(), 0, candidates, target, false, -1);
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> list, int index, int[] candidates, int target, boolean lastChoice, int lastVal) {
        if (index < candidates.length) {
            int candidate = candidates[index];
            if (target == candidate) {
                result.add(addNum(list, candidate));
            } else if (target > candidate) {
                //不能放弃上一个 选本个（重复情）
                if (lastChoice || candidate != lastVal) {
                    // 1 index
                    loop(result, addNum(new ArrayList<>(list), candidate), index + 1, candidates, target - candidate, true, candidate);
                }

                //0 index
                loop(result, list, index + 1, candidates, target, false, candidate);
            }
        }
    }

    private List<Integer> addNum(List<Integer> list, int num) {
        list.add(num);
        return list;
    }

}
