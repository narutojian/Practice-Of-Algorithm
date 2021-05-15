package Fudan.第三题;

import java.util.Arrays;

public class Solution2 {

    public int sumEqualE(int[] nums,int E) {
        int n = nums.length;
        int maxVal = 0;
        int minVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal += nums[i];
            minVal -= nums[i];
        }
        if (E > maxVal || E < minVal)
            return 0;
        int[][] memo = new int[n+1][E+maxVal-minVal+1];// memo[i][j] 表示为 用前i个物品 能够组成j的种数
        for (int[] row : memo) {
            Arrays.fill(row,-1);
        }
        return getOperations(nums,n,E-minVal,memo,minVal);
    }

    private int getOperations(int[] nums,int i,int target,int[][] memo,int minVal) {
        if (i == 0 && target+minVal == 0)
            return 1;
        if (i == 0 && target+minVal != 0)
            return 0;
        if (memo[i][target] != -1)
            return memo[i][target];
        int real = target+minVal;
        memo[i][target] = getOperations(nums,i-1,(real-nums[i-1])-minVal,memo,minVal)+getOperations(nums,i-1,real+nums[i-1]-minVal,memo,minVal);
        return memo[i][target];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        int[] nums = {1,2,2,1,1};
        int E = 3;

        System.out.println(solution2.sumEqualE(nums,E));
    }
}
