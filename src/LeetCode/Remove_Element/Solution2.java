package LeetCode.Remove_Element;

public class Solution2 {

    /**
     * 双指针 代码优化
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
                    nums[left] = nums[right];
                }
                right--;
            }
        }

        return left;
    }
}
