package LeetCode.Remove_Element;

/**
 * 27. Remove Element
 */
public class Solution {

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left <= right) {
            if (nums[left] != val)
                left++;
            else {
                if (nums[right] != val) {
                    swap(nums,left,right);
                }
                else right--;
            }
        }

        return left;
    }

    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
