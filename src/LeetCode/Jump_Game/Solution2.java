package LeetCode.Jump_Game;

public class Solution2 {

    /**
     * 贪心
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxStep = 1;

        for (int i = 0; i < n && maxStep > 0; i++) {
            maxStep--;
            maxStep = Math.max(maxStep,nums[i]);
            if (maxStep+i >= n-1)
                return true;
        }
        return false;
    }
}
