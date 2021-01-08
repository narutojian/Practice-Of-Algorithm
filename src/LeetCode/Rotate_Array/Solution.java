package LeetCode.Rotate_Array;

import java.util.Arrays;

/**
 * 189. Rotate Array
 */
public class Solution {

    /**
     * 数组右移k位就是先将1到（n-k）的数组进行逆置，
     * 在对后k位进行逆置，最后全部逆置，既得到右移k位后的结果
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // n小于k时 要取模 要不然数组越界
        if (n <= k) {
            k = k%n;
        }
        reverseArray(nums,0,n-k-1);
        reverseArray(nums,n-k,n-1);
        reverseArray(nums,0,n-1);
    }

    /**
     * 对数组的start到end范围内进行数组逆置
     * @param nums
     * @param start
     * @param end
     */
    public void reverseArray(int[] nums,int start,int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
        // test2
//        int[] nums = {-1,-100,3,99};
//        int k = 2;
        // test3
//        int[] nums = {-1};
//        int k = 2;
        // test4
//        int[] nums = {-1,2};
//        int k = 2;
        // test5
        int[] nums = {-1,2};
        int k = 3;
        solution.rotate(nums,k);

        System.out.println(Arrays.toString(nums));
    }
}
