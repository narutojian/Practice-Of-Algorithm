package LeetCode.count_number_of_nice_subarrays;

public class Solution3 {

    /**
     * 前缀和 + 差分
     * @param nums 数组序列
     * @param k 奇数个数
     * @return 子数组个数
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int[] frequency = new int[nums.length+1];
        int pre = 0,cur,ans = 0;
        frequency[0] = 1;
        for (int num : nums) {
            cur = pre + (num & 1);
            frequency[cur]++;
            if (cur - k >= 0) ans += frequency[cur - k];
            pre = cur;
        }
        return ans;
    }
}
