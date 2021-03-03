package LeetCode.Find_Peak_Element;

public class Solution2 {

    /**
     * 递归二分
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return search(0,nums.length-1,nums);
    }

    private int search(int left,int right,int[] nums) {
        if (left == right)
            return left;
        int mid = left+(right-left)/2;
        if (nums[mid] < nums[mid+1]) {
            // 右边是上升区间
            return search(mid+1,right,nums);
        }
        else return search(left,mid,nums);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] nums = {1,2,3,1};

        System.out.println(solution2.findPeakElement(nums));
    }
}
