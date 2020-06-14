package LeetCode.problem47;

import java.util.*;

/**
 * 这个解法在参考了LeetCode上一位大佬的解法的基础上产生的，emm不是跟那位一样的代码和思路
 * 解法：
 * 首先用的方法还是回溯，在dfs搜索下形成一个树的图形。通过这种画图，我得出：
 * 在同一层级下，不能有相同的数字出现。
 */
public class P47_Solution2 {
    private List<List<Integer>> ans = new ArrayList<>();
    private boolean[] used;

    private void fullPermute(List<List<Integer>> ans, int[] nums, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
//                if (i > 0 && nums[i] == nums[i-1] && used[i-1]) continue;
                if (map.containsKey(nums[i])) continue;
                used[i] = true;
                map.put(nums[i],true);
                stack.push(nums[i]);
                fullPermute(ans,nums,stack);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
//        Arrays.sort(nums);
        used = new boolean[nums.length];
        fullPermute(ans,nums,new Stack<Integer>());
        return ans;
    }

    public static void main(String[] args) {
        P47_Solution2 h = new P47_Solution2();
//        int[] nums = new int[] {2,2,1,1};
//        int[] nums = new int[] {1,2,3};
        int[] nums = new int[] {-1,2,-1,2,1,-1,2,1};
        List<List<Integer>>ans =  h.permuteUnique(nums);
        for (List<Integer> i :
                ans) {
            System.out.println(i.toString());
        }
    }
}
