package LeetCode.problem46;

import java.util.ArrayList;
import java.util.List;

public class P46_Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        dfs(nums,n,0,ans);
        return ans;
    }

    private void dfs(int[] nums,int n, int index,List<List<Integer>> ans) {
        if (index == n) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        for (int j = index; j < n; j++) {
            swap(nums,index,j);
            dfs(nums,n,index+1,ans);
            swap(nums,index,j);
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        P46_Solution2 h = new P46_Solution2();

//        int[] nums = {1,2,3};
        int[] nums = {1,2,3,4};

        List<List<Integer>> ans = h.permute(nums);

        System.out.println(ans);
    }
}
