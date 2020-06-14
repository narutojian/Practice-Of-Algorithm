package LeetCode.problem45;

public class P45 {

    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int len,left = n-1;
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            len = Math.min(n,i+nums[i]+1);
            if (len == n) dp[i] = 1;
            else if (len < left+1) dp[i] = Integer.MAX_VALUE;
            else {
                for (int j = len-1; j >= i+1 ; j--) {
                    dp[i] = Math.min(dp[i],dp[j]);
                }
                if (dp[i] != Integer.MAX_VALUE) dp[i]++;
            }
            if (dp[i] != Integer.MAX_VALUE) left = i;
        }

        return dp[0];
    }
}
