package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 */
public class Solution {
    private int n;

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        return permute(nums,0);
    }

    private List<List<Integer>> permute(int[] nums,int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == n-1) {
            List<Integer> temp = new ArrayList<>();
            for (int x : nums) {
                temp.add(x);
            }
            res.add(temp);
            return res;
        }

        for (int i = start; i < n; i++) {
            swap(nums,start,i);
            res.addAll(permute(nums,start+1));
            swap(nums,start,i);
        }
        return res;
    }

    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
