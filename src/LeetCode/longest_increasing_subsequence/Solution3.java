package LeetCode.longest_increasing_subsequence;

public class Solution3 {
    private int n;

    /**
     * 暴力递归 超时
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,getLength(nums,i));
        }
        return res;
    }

    /**
     * 定义 返回以nums[endPoint]为结尾的递增子序列的最大长度
     * @param nums
     * @param endPoint
     * @return
     */
    private int getLength(int[] nums,int endPoint) {
        if (endPoint == 0)
            return 1;
        int res = 1;
        for (int i = endPoint-1; i > -1; i--) {
            if (nums[endPoint] > nums[i]) {
                res = Math.max(res,1+getLength(nums,i));
            }
        }
        return res;
    }
}
