package LeetCode.Partition_Equal_Subset_Sum;

/**
 * 416. Partition Equal Subset Sum
 */
public class Solution {

    private int n;

    /**
     * 暴力递归
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 == 1)
            return false;
        return isExist(nums,0,0,total/2);
    }

    private boolean isExist(int[] nums,int index,int curSum,int target) {
        if (index == n)
            return false;
        if (curSum > target)
            return false;
        if (curSum == target)
            return true;
        return isExist(nums,index+1,curSum,target) || isExist(nums,index+1,curSum+nums[index],target);
    }
}
