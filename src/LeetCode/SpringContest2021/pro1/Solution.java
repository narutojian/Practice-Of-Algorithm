package LeetCode.SpringContest2021.pro1;

import java.util.Arrays;

public class Solution {

    public int purchasePlans(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007;
        Arrays.sort(nums);
        long res = 0;
        int diff;
        for (int i = 0; i < n - 1; i++) {
            diff = target - nums[i];
            if (diff < nums[i]) // target >= 2*nums[i]
                break;
            int last = binarySearch(nums,i+1,n,diff);
            res += last-i-1;
            if (last < n && nums[last] <= diff)
                res++;
        }

        return (int) (res % mod);
    }

    private int binarySearch(int[] nums,int left,int right,int target) {

        while (left < right) {
            int mid = left+(right-left)/2;
            if (nums[mid] < target) {
                left = mid+1;
            }
            else if (nums[mid] == target) {
                left = mid+1;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = {2,5,3,5};
//        int target = 6;

//        int[] nums = {2,2,1,9};
//        int target = 10;

        int[] nums = {2,2,2,1,1};
        int target = 4;

        System.out.println(solution.purchasePlans(nums,target));
    }
}
