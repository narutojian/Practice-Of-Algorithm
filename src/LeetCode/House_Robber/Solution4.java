package LeetCode.House_Robber;

public class Solution4 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int fir = nums[0];
        int sec = Math.max(fir,nums[1]);
        int next;

        for (int i = 2; i < n; i++) {
            next = Math.max(sec,fir+nums[i]);

            // 更新
            fir = sec;
            sec = next;
        }

        return sec;
    }
}
