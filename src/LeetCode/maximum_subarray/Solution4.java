package LeetCode.maximum_subarray;

public class Solution4 {

    /**
     * 贪心 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i-1]+nums[i];
        }

        int res = prefix[0];
        int left = 0;// 维护prefix最小值索引
        int right = 0;// 维护prefix最大值索引

        for (int i = 1; i < n; i++) {
            if (prefix[right] < prefix[i]) {
                right = i;
            }
            res = Math.max(res,Math.max(prefix[i],prefix[i]-prefix[left]));
            if (prefix[left] > prefix[i]) {
                left = i;
            }
        }
        return res;
    }
}
