package LeetCode.longest_increasing_subsequence;

public class Solution2 {

    /**
     * 贪心+二分查找
     * d[i] 存储 长度为i的上升子序列中末尾的最小值
     * d[i] 关于i单调递增
     * @param nums 数组序列
     * @return 最长上升子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length+1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 二分查找 最终的值以左边界为准；如果没有一个值满足，则更新d[1]
                int l = 1,r = len,pos = 0;
                while (l <= r) {
                    int mid = (l+r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid+1;
                    } else {
                        r = mid -1;
                    }
                }
                d[pos+1] = nums[i];
            }
        }
        return len;
    }
}
