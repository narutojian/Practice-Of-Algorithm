package LeetCode.Next_Permutation;

/**
 * 31. Next Permutation
 */
public class Solution {

    /**
     * 官方题解
     * 找到左边较小的数a，要尽可能的靠右
     * 找到a右边的里较大的数b，这个较大的数要尽可能的小
     * 然后交换a与b，并将b右边的数组 按升序排列
     * 使得变大的程度最小
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // 找左边较小的数 该数要尽量靠右
        int minIndex = -1;
        for (int i = n-1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                minIndex = i-1;
                break;
            }
        }
        if (minIndex == -1)
            reverse(nums,0,n-1);
        else {
            // 找右边较大的数 要尽可能的小
            int maxIndex = -1;
            for (int i = n-1; i > minIndex; i--) {
                if (nums[i] > nums[minIndex]) {
                    maxIndex = i;
                    break;
                }
            }
            // 交换较大值和较小值
            int temp = nums[minIndex];
            nums[minIndex] = nums[maxIndex];
            nums[maxIndex] = temp;
            // 返回较大值右边的数 使右边的数升序排列 使得变化的程度最小
            reverse(nums,minIndex+1,n-1);
        }
    }

    private void reverse(int[] nums,int left,int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
