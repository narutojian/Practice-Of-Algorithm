package LeetCode;

import java.util.PriorityQueue;

public class P4 {

    /**
     * 自己想的一种特别耗时的方法
     * 把所有数据放入到优先队列中，然后在看队列的长度，偶数的话要取两个数，奇数只要取一个数。
     * 然后依次序把中位数之前的数都从队列中移除，最后得出结果。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int length = nums1.length + nums2.length;
        int num = 0;

        for (int i = 0; i < nums1.length; i++)
            queue.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            queue.add(nums2[i]);

        if (length%2 == 0){
            length /= 2;
            for (int i = 0; i < length-1; i++)
                queue.poll();
            num += queue.poll();
            num += queue.poll();

            return num/2.0;
        }
        else {
            length /= 2;
            for (int i = 0; i < length; i++)
                queue.poll();
            return queue.poll()*1.0;
        }
    }
}
