package LeetCode.Two_Sum_II_Input_array_is_sorted;

public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = 1;

        while (left < right && right < numbers.length) {
            int sum = numbers[left]+numbers[right];
            if (sum == target) {
                return new int[] {left+1,right+1};
            }
            if (sum < target) {
                if (right == numbers.length-1) {
                    left++;
                }
                else right++;
            }
            else if (sum > target) {
                right--;
                left++;
            }
        }
        return null;
    }
}
