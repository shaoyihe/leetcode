package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *  https://leetcode.com/problems/combinations/description/
 *  77. Combinations
 * </pre>
 * on 2018/8/2.
 */
public class Solution077 {
    public static void main(String[] args) {
        Solution077 solution11 = new Solution077();
        System.err.println(solution11.combine(4, 2));
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        loop(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void loop(List<List<Integer>> result, List<Integer> list, int index, int n, int k) {
        int size = list.size();
        if (size == k) {
            result.add(list);
        } else if (index <= n && size + n - index + 1 >= k) {
            // 1 index
            loop(result, addNum(new ArrayList<>(list), index), index + 1, n, k);

            //0 index
            loop(result, list, index + 1, n, k);
        }
    }

    private List<Integer> addNum(List<Integer> list, int num) {
        list.add(num);
        return list;
    }

}
