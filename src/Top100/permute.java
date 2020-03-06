package Top100;

import java.util.ArrayList;
import java.util.List;

public class permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, res);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(nums, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

}
