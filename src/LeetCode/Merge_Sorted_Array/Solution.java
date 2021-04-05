package LeetCode.Merge_Sorted_Array;

/**
 * 88. Merge Sorted Array
 */
public class Solution {

    /**
     * 双指针
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
        int point1 = 0;
        int point2 = 0;
        while (point1 != m || point2 != n) {
            int curVal;
            int p = point1+point2;
            if (point1 == m) {
                curVal= nums2[point2++];
            }
            else if (point2 == n) {
                curVal= nums1Copy[point1++];
            }
            else {
                if (nums1Copy[point1] > nums2[point2]) {
                    curVal = nums2[point2++];
                }
                else curVal = nums1Copy[point1++];
            }
            nums1[p] = curVal;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        solution.merge(nums1,m,nums2,n);
    }
}
