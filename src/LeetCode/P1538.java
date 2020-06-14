package LeetCode;

import java.util.Arrays;

public class P1538 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};
        if (k == arr.length) return arr;

        int[] queue = new int[k];
        queue[0] = arr[0];
        int queueLength = 0,index = 0;

        for (int i = 1; i < arr.length; i++) {
            while (index >= 0 && queue[index] > arr[i])
                index--;
            if (queueLength == queue.length-1) {
                if (index != queueLength)
                    insertValue(queue,index+1,queueLength-1,arr[i]);
            }
            else {
                if (index == queueLength)
                    queue[++queueLength] = arr[i];
                else {
                    insertValue(queue,index+1,queueLength,arr[i]);
                    queueLength++;
                }
            }
            index = queueLength;
        }
        return queue;
    }

    private void insertValue(int[] arr, int insertIndex,int tail, int value) {
        for (int i = tail+1; i > insertIndex; i--)
            arr[i] = arr[i-1];
        arr[insertIndex] = value;
    }

    /**
     * 对数组排序，然后取前k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_Solution2(int[] arr, int k) {
        if (k == 0) return new int[] {};
        if (k == arr.length) return arr;
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }

    public static void main(String[] args) {
        P1538 h = new P1538();
        int[] arr = {3,2,1};
        int k = 2;

//        int[] ans = h.getLeastNumbers(arr,k);
        int[] ans = h.getLeastNumbers_Solution2(arr,k);
        for (int i :
                ans) {
            System.out.print(i+"  ");
        }
        System.out.println();
    }
}
