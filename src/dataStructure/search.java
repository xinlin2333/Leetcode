package dataStructure;

/**
 * @author canoeYang
 * @Date 2020-03-08 20:07
 */
public class search {
    /**
     * 顺序查找：顺序扫描链表，将关键子与定值比较
     */
    public static int seqSearch(int[] arr, int k) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 二分查找：
     * 时间复杂度：
     */
    public static int binSearch(int[] arr, int n, int k) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
