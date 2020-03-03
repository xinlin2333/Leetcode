package Top100;

import java.util.ArrayList;
import java.util.List;

public class subSet {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findSub(res, cur, 0, nums);
        return res;
    }

    public void findSub(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>());
            return;
        }
        cur.add(nums[index]);
        findSub(res, cur, index + 1, nums);
        cur.remove(cur.size() - 1);
        findSub(res, cur, index + 1, nums);
    }

}
