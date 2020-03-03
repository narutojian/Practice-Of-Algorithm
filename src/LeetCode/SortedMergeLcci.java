package LeetCode;

import java.util.Arrays;

public class SortedMergeLcci {
    /**
     * 双指针解法，感觉有点像归并排序
     * @param A 数组A，所有数据存储到数组A中
     * @param m A数组中原先数据的长度
     * @param B 数组B，将数组B中的数据存放到数组A中
     * @param n 数组B的长度
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int[] C = Arrays.copyOf(A,m);
        int i = 0,j = 0,index = 0;
        while (i < m && j < n) {
            if (C[i] < B[j]) A[index++] = C[i++];
            else A[index++] = B[j++];
        }
        for (;i < m;i++)
            A[index++] = C[i];
        for (;j < n;j++)
            A[index++] = B[j];
    }

    /**
     * 双指针 空间复杂度优化到O(1)
     * @param A 数组A，所有数据存储到数组A中
     * @param m A数组中原先数据的长度
     * @param B 数组B，将数组B中的数据存放到数组A中
     * @param n 数组B的长度
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int i = m-1,j = n-1,index = m+n-1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) A[index--] = B[j--];
            else A[index--] = A[i--];
        }
        while (i >= 0) A[index--] = A[i--];
        while (j >= 0) A[index--] = B[j--];
    }
}
