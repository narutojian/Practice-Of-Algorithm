package LeetCode.maximum_subarray;

public class Solution2 {

    /**
     * 贪心算法 滑动窗口
     * @param nums 数组
     * @return 数组连续子序列的最大和
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        // start 窗口的第一个指针；end 窗口的第二个指针；curValue 窗口的总值
        int start = 0,end = 0,curValue = 0;

        for (; end < nums.length; end++) {
            if (curValue < 0 && nums[end] > curValue) {
                start = end;
                curValue = 0;
            }
            curValue += nums[end];

            ans = Math.max(ans,curValue);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2 h = new Solution2();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(h.maxSubArray(nums));
    }
}
