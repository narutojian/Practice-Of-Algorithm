package LeetCode.Two_Sum_II_Input_array_is_sorted;

public class Solution2 {

    /**
     * 二分查找 优化 遍历的话 小的在前面 那么left应该初始设为该数索引的下一个
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int other = target-numbers[i];
            int left = i+1;
            int right = n-1;

            while (left <= right) {
                int mid = left+(right-left)/2;
                if (numbers[mid] == other) {
                    return new int[]{i+1,mid+1};
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
