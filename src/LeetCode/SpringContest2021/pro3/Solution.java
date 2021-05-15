package LeetCode.SpringContest2021.pro3;

public class Solution {

    public int magicTower(int[] nums) {
        int n = nums.length;
        int sum = 1;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < 0)
            return -1;
        return dfs(nums,0,1,0);
    }

    private int dfs(int[] nums,int i,int life,int operation) {
        if (i == nums.length)
            return operation;
        if (nums[i] >= 0)
            return dfs(nums,i+1,life+nums[i],operation);
        else {
            if (life+nums[i] < 0) {
                operation++;
                return dfs(nums,i+1,life,operation);
            }
            else {
                return Math.min(dfs(nums,i+1,life+nums[i],operation),dfs(nums,i+1,life,operation+1));
            }
        }
    }
}
