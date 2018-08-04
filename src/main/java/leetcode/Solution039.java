package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/combination-sum/description/
 *  39. Combination Sum
 * </pre>
 * on 2018/8/2.
 */
public class Solution039 {
    public static void main(String[] args) {
        Solution039 solution11 = new Solution039();
        int[] arr = {2, 3, 5};
        System.err.println(solution11.combinationSum(arr, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        loop(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> list, int index, int[] candidates, int target) {
        if (index < candidates.length) {
            int candidate = candidates[index];
            int maybeMaxNumber = target / candidate;
            if (maybeMaxNumber > 0) {
                int mode = target % candidate;
                if (mode == 0) {
                    result.add(addRepeatNum(list, candidate, maybeMaxNumber));
                }
                if (maybeMaxNumber > 1 || mode > 0) {
                    for (int i = 0; i < maybeMaxNumber; ++i) {
                        if (i == maybeMaxNumber - 1) {
                            loop(result, addRepeatNum(list, candidate, i), index + 1, candidates, target - candidate * i);
                        } else {
                            loop(result, addRepeatNum(new ArrayList<>(list), candidate, i), index + 1, candidates, target - candidate * i);
                        }
                    }
                }
            }
        }
    }

    private List<Integer> addRepeatNum(List<Integer> list, int num, int times) {
        for (int i = 0; i < times; ++i) list.add(num);
        return list;
    }

}
