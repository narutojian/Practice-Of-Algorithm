package LeetCode.Partition_Equal_Subset_Sum;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    private int n;
    private Set<Integer> memo;//保存现有的状态

    /**
     * dp 递归 记忆化
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        n = nums.length;
        memo = new HashSet<>();
        memo.add(0);
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 == 1)
            return false;
        return isExist(nums,0,total/2);
    }

    private boolean isExist(int[] nums,int index,int target) {
        if (index == n)
            return false;
        Set<Integer> tempMemo = new HashSet<>();
        for (int key : memo) {
            int temp = key + nums[index];
            if (temp == target)
                return true;
            if (temp < target)
                tempMemo.add(temp);
        }
        memo.addAll(tempMemo);
        return isExist(nums,index+1,target);
    }
}
