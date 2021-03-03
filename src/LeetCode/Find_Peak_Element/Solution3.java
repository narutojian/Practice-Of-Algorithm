package LeetCode.Find_Peak_Element;

public class Solution3 {

    /**
     * 迭代 二分
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left < right) {
            mid = left+(right-left)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid+1;
            }
            else right = mid;
        }
        return left;
    }
}
