package LeetCode;

public class P55 {

    public boolean canJump(int[] nums) {
        boolean[] ans = new boolean[nums.length];
        ans[nums.length-1] = true;
        int index = nums.length-1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (i+nums[i] >= index) {
                ans[i] = true;
                index = i;
            }
        }
        return ans[0];
    }
}
