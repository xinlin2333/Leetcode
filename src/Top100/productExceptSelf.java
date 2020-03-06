package Top100;

public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = val;
            val = val * nums[i];
        }
        val = 1;
        for (int j = nums.length; j >= 0; j--) {
            res[j] = val;
            val = val * nums[j];

        }
        return res;
    }
}
