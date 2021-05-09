package LeetCode.House_Robber;

public class Solution2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0],nums[1]);
        if (n == 3)
            return Math.max(nums[0]+nums[2],nums[1]);
        int fir = nums[0];
        int sec = nums[1];
        int thr = Math.max(nums[0]+nums[2],nums[1]);
        int next;
        for (int i = 3; i < n; i++) {
            next = Math.max(fir,sec)+nums[i];
            fir = sec;
            sec = thr;
            thr = next;
        }
        return Math.max(sec,thr);
    }
}
