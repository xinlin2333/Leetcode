package EveryDay;

/**
 * @author canoeYang
 * @Date 2020-03-07 14:20
 */
public class MaxQueue {
    /**
     * 模拟队列并且要求时间复杂度为1（用空间换时间）
     * 使用两个数组，一个数组Queue模拟正常队列的入队和出队；一个数组MaxQueue用于实现max_value
     * 1、max_value () 如果MaxQueueHead==MaxQueueTail,那么表示对列中没有元素返回null’；头指针处保留的是最大值
     * 2、push_back() 正常添加数据，Queue[QueueTail++] =value;那么需要注意的是在MaxQureue要jinx判断：
     * 比value小的值，一定在value出栈前，先出栈，队列中最大值最少都是value
     * 3、pop_front() Queue中head的值与MaxQueue中的head值相等，则两个数组中的head都要++，因为最大的值已经变了
     */
    int[] Queue;
    int QueueHead = 0;
    int QueueTail = 0;
    int[] MaxQueue;
    int MaxQueueHead = 0;
    int MaxQueueTail = 0;

    public MaxQueue() {
        Queue = new int[10000];
        MaxQueue = new int[10000];
    }

    public int max_value() {
        if (MaxQueueHead == MaxQueueTail) {
            return -1;
        }
        return MaxQueue[MaxQueueHead];
    }

    public void push_back(int value) {
        Queue[QueueTail++] = value;
        while (MaxQueueHead != MaxQueueTail && MaxQueue[MaxQueueTail - 1] < value) {
            MaxQueueTail--;
        }
        MaxQueue[MaxQueueTail++] = value;
    }

    public int pop_front() {
        if (QueueHead == QueueTail) {
            return -1;
        }
        int res = Queue[QueueTail];
        if (res == MaxQueue[MaxQueueHead]) {
            MaxQueueHead++;
        }
        QueueHead++;
        return res;
    }
}
