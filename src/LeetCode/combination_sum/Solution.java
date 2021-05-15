package LeetCode.combination_sum;

import java.util.LinkedList;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class Solution {
    // 全局变量 存放最终结果
    List<List<Integer>> ans = new LinkedList<>();
    // 全局变量 存放每一个combination的candidates
    List<Integer> record = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,0,candidates,target);
        return ans;
    }

    /**
     * 回溯法 解决所有可行解相关的问题
     * @param sum 当前已选candidate的总和
     * @param index 选择下一个candidate的位置
     * @param candidates candidate数组
     * @param target 目标值
     */
    void dfs(int sum,int index,int[] candidates,int target) {
        if (sum > target) return;
        if (sum == target) {
            List<Integer> temp = new LinkedList<>(record);
            ans.add(temp);
        }
        else {
            for (int i = index; i < candidates.length; i++) {
                record.add(candidates[i]);
                dfs(sum+candidates[i],i,candidates,target);
                record.remove(record.size()-1); // 回溯
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //test1
        int[] candidates = {2,3,6,7};
        int target = 7;
        //test2
//        int[] candidates = {2};
//        int target = 1;
        //test3
//        int[] candidates = {1};
//        int target = 1;
        //test4
//        int[] candidates = {1};
//        int target = 2;
        List<List<Integer>> ans = solution.combinationSum(candidates,target);
        for (List<Integer> i :
                ans) {
            System.out.println(i);
        }
    }
}
