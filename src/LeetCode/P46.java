package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于给定的没有重复数字的序列，输出其全排列
 */

public class P46 {

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 全排列 回溯法
     * @param ans 排列后的结果集
     * @param nums 待排序列
     * @param start 待排序列从start开始
     */
    public void fullPermute(List<List<Integer>> ans, int[] nums ,int start) {
        // 如果待排序列只有剩最后一个数，那么直接返回结果
        if (start == nums.length -1) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }

        // 如果待排序列为1，2，3，4，那么只要交换1和2，1和3，1和4，然后在这样递归下去就可以得到所有结果
        for (int i = start; i < nums.length; i++) {
            if (i == start) {
                fullPermute(ans,nums,start+1);
            }
            else {
                swap(nums,i,start);
                fullPermute(ans,nums,start+1);
                swap(nums,i,start);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        fullPermute(ans,nums,0);
        return ans;
    }
}
