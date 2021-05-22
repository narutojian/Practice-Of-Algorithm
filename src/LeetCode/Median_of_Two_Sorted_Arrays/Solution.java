package LeetCode.Median_of_Two_Sorted_Arrays;

/**
 * 4. Median of Two Sorted Arrays
 */
public class Solution {

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m+n == 0)
            return 0;

        int fir = 0;
        int cnt = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n && cnt < (m+n+1)/2) {
            fir = Math.min(nums1[index1],nums2[index2]);
            if (nums1[index1] < nums2[index2]) {
                index1++;
            }
            else index2++;
            cnt++;
        }
        while (index1 < m && cnt < (m+n+1)/2) {
            fir = nums1[index1++];
            cnt++;
        }
        while (index2 < n && cnt < (m+n+1)/2) {
            fir = nums2[index2++];
            cnt++;
        }
        if ((m+n) % 2 == 1)
            return fir;

        int sec = Math.min(index1 < m ? nums1[index1] : Integer.MAX_VALUE,index2 < n ? nums2[index2] : Integer.MAX_VALUE);
        return (fir+sec)*1.0/2;
    }
}