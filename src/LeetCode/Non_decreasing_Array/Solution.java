package LeetCode.Non_decreasing_Array;

/**
 * 665. Non-decreasing Array
 */
public class Solution {

    /**
     * 模拟
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i+1];

            if (x > y) {
                nums[i] = y;
                if (isNonDecreasing(nums))
                    return true;
                nums[i] = x;
                nums[i+1] = x;
                return isNonDecreasing(nums);
            }
        }
        return true;
    }

    private boolean isNonDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1])
                return false;
        }
        return true;
    }
}
