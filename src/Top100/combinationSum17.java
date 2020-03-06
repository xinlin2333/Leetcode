package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum17 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, res, 0, candidates, target);
        return res;
    }

    public void backtrack(List<Integer> list, List<List<Integer>> res, int index, int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < 0) {
                break;
            }
            list.add(candidates[i]);
            backtrack(list, res, i, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
