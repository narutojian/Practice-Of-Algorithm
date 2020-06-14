package LeetCode;

public class P33 {
    /**
     * 二分搜索 复杂度 O(logN)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] != target) return -1;
        int pivot = getPivot(nums);
        if (nums[0] == target) return 0;
        else if (nums[0] < target) {
            return binarySearch(nums,0,pivot-1,target);
        }
        else return binarySearch(nums,pivot,nums.length-1,target);
    }

    private int getPivot(int[] nums) {
        int low = 0,high = nums.length-1;
        int mid;
        while (low < high) {
            mid = (low+high)/2;
            if (nums[mid] >= nums[low]) {
                if (mid+1 < nums.length && nums[mid+1] < nums[mid]) return mid+1;
                low = mid+1;
            }
            else {
                if (mid-1 >= 0 && nums[mid-1] > nums[mid]) return mid;
                high = mid-1;
            }
        }
        return nums.length;
    }

    private int binarySearch(int[] nums,int left,int right,int target) {
        int mid;

        while (left <= right) {
            mid = (left+right)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid-1;
            }
            else left = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P33 h = new P33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 3;

//        int[] nums = {1,2,4,5,6,7,0};
//        int target = 0;

//        int[] nums = {7,0,1,2,4,5,6};
//        int target = 0;

//        int[] nums = {5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = {6,7,0};
//        int target = 0;

//        int[] nums = {7,0};
//        int target = 0;

//        int[] nums = {1,3};
//        int target = 0;

//        int[] nums = {1,3};
//        int target = 3;

//        int[] nums = {1,3,4,5,7,8};
//        int target = 0;
        System.out.println(h.search(nums,target));
    }
}
