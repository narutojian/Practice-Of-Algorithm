package LeetCode.Maximum_Product_Subarray;

public class Solution2 {

    /**
     * dp
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];// max[i] 表示 以nums[i]为结尾的最大乘积
        int[] min = new int[n];// min[i] 表示 以nums[i]为结尾的最小乘积
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1]*nums[i],Math.max(min[i-1]*nums[i],nums[i]));
            min[i] = Math.min(max[i-1]*nums[i],Math.min(min[i-1]*nums[i],nums[i]));
            res = Math.max(res,max[i]);
        }
        return res;
    }
}
