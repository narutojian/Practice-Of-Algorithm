package LeetCode.Search_in_Rotated_Sorted_Array;

/**
 * 33. Search in Rotated Sorted Array
 */
public class Solution {

    /**
     * 二分查找
     * 但由于查找旋转点需要O(n)的时间复杂度
     * 故最终的时间复杂度依旧是O(n) 而不是O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = 0;// 旋转坐标点
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre > nums[i]) {
                k = (i-1)%n;
                break;
            }
            pre = nums[i];
        }

        int temp = binarySearch(0,k,target,nums);
        if (temp != -1)
            return temp;
        return binarySearch(k+1,n-1,target,nums);
    }

    private int binarySearch(int left,int right,int target,int[] nums) {
        int mid;

        while (left <= right) {
            mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid+1;
            }
            else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(solution.search(nums,target));
    }
}
