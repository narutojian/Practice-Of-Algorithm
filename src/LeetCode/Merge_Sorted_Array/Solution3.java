package LeetCode.Merge_Sorted_Array;

public class Solution3 {

    /**
     * 双指针 优化
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while (p1 != -1 && p2 != -1) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            }
            else nums1[p--] = nums2[p2--];
        }
        while (p2 != -1) {
            nums1[p--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        solution3.merge(nums1,m,nums2,n);
    }
}
