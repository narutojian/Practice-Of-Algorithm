package LeetCode.Combination_Sum_II;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    // 全局变量 记录当前combination的candidate
    List<Integer> record = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,0,candidates,target);
        return ans;
    }

    /**
     * 回溯法 在combination sum上进行了一些条件限制 进行了一些剪枝操作
     * @param sum 当前已选candidate的总和
     * @param index 下一个candidate的位置
     * @param candidates candidate的数组
     * @param target 目标值
     */
    void dfs(int sum,int index,int[] candidates,int target) {
        if (sum == target) {
            List<Integer> temp = new LinkedList<>(record);
            ans.add(temp);
        }
        else {
            for (int i = index; i < candidates.length; i++) {
                // 剪枝方法一：排序后 一旦遇到大的 后面的数就不需要看了
                if (sum+candidates[i] >target) return;
                // 剪枝方法二：重复的数字需要排除掉
                if (i != index && candidates[i] == candidates[i-1]) continue;
                record.add(candidates[i]);
                dfs(sum+candidates[i],i+1,candidates,target);
                record.remove(record.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // test1
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;
        // test2
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
        //test3
//        int[] candidates = {2,2,2,2};
//        int target = 4;
        //test4
//        int[] candidates = {1};
//        int target = 2;
        //test5
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> ans = solution.combinationSum2(candidates,target);
        for (List<Integer> i :
                ans) {
            System.out.println(i);
        }
    }
}
