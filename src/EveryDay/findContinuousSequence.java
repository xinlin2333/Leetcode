package EveryDay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        //用两个指针，表示连续正序列的首尾
        List<int[]> res = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high && high < target) {
            int sum = (low + high) * (high - low + 1) / 2;
            if (sum < target) {
                high++;
            } else if (sum > target) {
                low++;
            } else {
                int[] temp = new int[high - low + 1];
                for (int i = 0; i < high - low + 1; i++) {
                    temp[i] = i + low;
                }
                res.add(temp);
                low++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
