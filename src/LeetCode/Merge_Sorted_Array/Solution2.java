package LeetCode.Merge_Sorted_Array;

public class Solution2 {

    /**
     * 双指针 改版
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 != m && p2 != n) {
            if (nums1Copy[p1] > nums2[p2])
                nums1[p++] = nums2[p2++];
            else nums1[p++] = nums1Copy[p1++];
        }
        while (p1 != m) {
            nums1[p++] = nums1Copy[p1++];
        }
        while (p2 != n) {
            nums1[p++] = nums2[p2++];
        }
    }
}
