package LeetCode.Permutations_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 */
public class Solution {
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
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
        // 剪枝 去除重复的交换
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (!set.add(nums[i]))
                continue;
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
