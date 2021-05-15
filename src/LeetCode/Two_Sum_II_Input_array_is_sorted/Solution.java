package LeetCode.Two_Sum_II_Input_array_is_sorted;

/**
 * 167. Two Sum II - Input array is sorted
 */
public class Solution {

    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int other = target-numbers[i];
            int left = 0;
            int right = n-1;

            while (left <= right) {
                int mid = left+(right-left)/2;
                if (numbers[mid] == other) {
                    if (mid == i) {
                        left = mid+1;
                    }
                    else return new int[] {Math.min(i,mid)+1,Math.max(i,mid)+1};
                }
                else if (numbers[mid] < other) {
                    left = mid+1;
                }
                else if (numbers[mid] > other) {
                    right = mid-1;
                }
            }
        }
        return null;
    }
}
