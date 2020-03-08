package Top100;

/**
 * @author canoeYang
 * @Date 2020-03-08 23:59
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = nums.length - 1;
        // 上边界
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] != target) {
            return new int[]{-1, -1};
        }
        res[0] = low;
        low = 0;
        high = nums.length - 1;
        //下边界
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        res[1] = high;
        return res;

    }
}
