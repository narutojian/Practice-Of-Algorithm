package LeetCode.Summary_Ranges;

import java.util.LinkedList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
public class Solution {

    /**
     * 一次遍历
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new LinkedList<>();
        if (n == 0) return ans;
        int start = nums[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]+1) {
                count++;
            }
            else {
                // 添加区间
                if (count == 0) {
                    ans.add(""+start);
                }
                else {
                    ans.add(""+start+"->"+(start+count));
                }
                // 更新
                count = 0;
                start = nums[i];
            }
        }
        // 最后一个区间
        if (count == 0) {
            ans.add(""+start);
        }
        else {
            ans.add(""+start+"->"+(start+count));
        }

        return ans;
    }
}
