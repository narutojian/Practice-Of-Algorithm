package LeetCode.count_number_of_nice_subarrays;

/**
 * 1248. Count Number of Nice Subarrays
 */
public class Solution {
    /**
     * 滑动窗口
     * @param nums 数组序列
     * @param k 需要的奇数个数
     * @return 符合要求的子数组
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0,pre = -1,start = -1,end = 0,sum = 0;

        for (;end < nums.length;end++) {
            // end指向的为奇数
            if ((nums[end]&1) == 1) {
                // 如果此时end指向的位置也是一个奇数,则说明上一个k个奇数的区间所有满足要求的个数都已统计
                // 现在让pre移到start位置，start向右移到下一个奇数的位置
                if (sum == k) {
                    pre = start++;
                    while ((nums[start]&1) != 1) {
                        start++;
                    }
                }
                else {
                    if (start == -1) start = end;
                    sum++;
                }
            }
            // 结算子数组个数
            if (sum == k) {
                ans += (start - pre);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(h.numberOfSubarrays(nums,k));
    }
}
