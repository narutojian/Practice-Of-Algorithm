package LeetCode.Summary_Ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    /**
     * 双指针
     * 上一种自己的解法在处理最后一个区间时 代码有点重复
     * 看了题解区后 重新优化下
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        int start = 0;// 开始指针
        // i作为结束指针
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1 || nums[i]+1 != nums[i+1]) {
                if (start == i) {
                    ans.add(""+nums[start]);
                }
                else {
                    ans.add(""+nums[start]+"->"+nums[i]);
                }
                start = i+1;
            }
        }
        return ans;
    }
}
