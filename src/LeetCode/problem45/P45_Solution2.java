package LeetCode.problem45;

public class P45_Solution2 {
    private int ans = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        dfs(nums,0,nums.length-1,0);
        return ans;
    }

    private void dfs(int[] nums,int start,int target,int step) {
        if (step >= ans) return;
        if (start == target) {
            ans = step;
            return;
        }

        int len = Math.min(nums.length-1,start+nums[start]);
        for (int i = len; i >= start+1; i--) {
            dfs(nums,i,target,step+1);
        }
    }

    public static void main(String[] args) {
        P45_Solution2 h = new P45_Solution2();

        int[] nums = {2,3,1,1,4};
        System.out.println(h.jump(nums));
    }
}
