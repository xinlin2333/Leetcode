package dataStructure;

import java.util.Arrays;

public class sort {

    // 插入排序

    /**
     * 直接插入排序
     * 思想默认0，i-1为有序，i，n-1为待排序，i元素与前0-i-1比较，找到合适的位置
     * 时间复杂度：O(N^2) 空间复杂度：O(1)
     * 稳定
     */
    public static void insertSort(int[] arr, int n) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

    }


    /**
     * 希尔排序
     * 思想：分组插入；把一个小于n的整数d作为第一个增量，把表的全部记录分成d个组，所有距离为d的记录放在同一个组中，在各组内直接插入排序
     * 然后再取第二个增量d2<d1，重复上述排序,当增量减至1，整个文件恰好被分成一组，算法终止
     * 时间复杂度：最好O（n^1.3) 最坏O（n^2) 空间复杂度：O（1）
     */
    public static void shellSort(int[] arr, int n) {
        int d = n / 2;
        while (d > 0) {
            for (int i = d; i < n; i++) {
                int tmp = arr[i];
                int j = i - d;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + d] = arr[j];
                    j -= d;
                }
                arr[j + d] = tmp;
            }
            d /= 2;
        }
    }


    // 交换排序

    /**
     * 冒泡排序
     * 思想：通过无续重相邻记录关键字间的比较和位置的交换，使关键子最大的记录一直往下
     * 时间复杂度：O（n^2),空间复杂度：O（1）
     * 稳定
     */
    public static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 思想：通过一趟排序将待排序记录分隔成两部分，其中一部分记录的关键子比另一部分小
     * 从数列中挑选一个元素作为pivot；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准后面
     * 递归操作
     * 时间复杂度：O（nlog2n) 空间复杂度：O（nlogn）
     */
    public static void quickSort(int[] arr, int s, int t) {
        int i = s, j = t, k;
        if (s < t) {
            int tmp = arr[s];// 用区间的第1个记录作为基准
            while (i != j) {     // 从区间两端交替向中间扫描，直至i=j为止
                while (j > i && arr[j] > tmp) {
                    j--; // 从右向左扫描，找第一个关键字小于tmp
                }
                if (i < j) {     // 表示找到这样的arr[j],arr[i],arr[j]交换
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < tmp) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = tmp;
            quickSort(arr, s, i - 1);
            quickSort(arr, i + 1, t);
        }
    }


    // 选择排序

    /**
     * 直接选择排序
     * 思想：在未排序的列中找到最小元素，存放到排序序列的起始位置，然后再从剩余未排序的元素中继续寻找最小（大）元素
     * 时间复杂度：O（n^2) 空间复杂度：O（1）
     */
    public static void selectSeot(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * 堆排序
     * 思想：子节点的键值或索引小于它的父节点
     * 将初始排序关键字序列构成大顶堆，此堆为初始的无序区
     * 将堆顶元素的arr[1]与最后一个元素arr[n]交换，此时得到无序区
     * 由于交换后新的堆顶可能违反堆的性质，所以需要调整
     * <p>
     * 时间复杂度：O（nlogn) 空间复杂度：O（1)
     */
    static int len;

    public void heapSort(int arr[]) {
        len = arr.length;
        if (len < 1)
            return;
        // 1、构建一个最大堆
        buildMaxHeap(arr);

    }

    public static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len / 2 - 1); i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    public static void adjustHeap(int[] arr, int i) {
        int maxIdx = i;
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && arr[i * 2] > arr[maxIdx]) {
            maxIdx = i * 2;
        }
        // 如果有右子树，且右子树大于父节点，则将指针指向右子树
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIdx]) {
            maxIdx = i * 2 + 1;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调正与父节点交换的位置
        if (maxIdx != i) {
            swap(arr, maxIdx, i);
            adjustHeap(arr, maxIdx);
        }
    }

    public static void swap(int[] arr, int maxIdx, int i) {
        int tmp = arr[i];
        arr[i] = arr[maxIdx];
        arr[maxIdx] = tmp;
    }

    /**
     * 归并排序
     * 思想：采用分治法。将已有序的子序列合并，得到完全有序的序列；2-路归并
     * 将长度为n的输入序列分成两个长度为n/2的子序列
     * 对者两个子序列分别采用归并排序
     * 将两个排序好的子序列合并成一个最终的排序序列
     * 时间复杂度：O（nlogn) 空间复杂度：O（n)
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int index = 0;
        int i = 0;
        int j = 0;
        for (; index < res.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                res[index] = right[j++];
            } else {
                res[index] = left[i++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 4, 0, 3, 8, 6};
        //insertSort(arr,arr.length);
        //shellSort(arr,arr.length);
        //bubbleSort(arr,arr.length);
        //quickSort(arr,0,arr.length-1);
        //selectSeot(arr,arr.length);

        int[] res = new int[arr.length];
        res = mergeSort(arr);
        System.out.print(res);
    }
}
