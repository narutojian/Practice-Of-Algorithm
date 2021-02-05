package LeetCode.Get_Equal_Substrings_Within_Budget;

/**
 * 1208. Get Equal Substrings Within Budget
 */
public class Solution {
    /**
     * 双指针
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int start = -1;// 起始点
        int curSum = 0;
        // i为终止点
        for (int i = 0; i < s.length(); i++) {
            int gap = Math.abs(s.charAt(i)-t.charAt(i));
            curSum += gap;
            // 不满足限制条件 左边界右移 直到符合条件
            if (curSum > maxCost) {
                while (curSum > maxCost) {
                    ++start;
                    curSum -= Math.abs(s.charAt(start) - t.charAt(start));
                }
            }
            // 更新长度
            maxLen = Math.max(maxLen,i-start);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        System.out.println(solution.equalSubstring(s,t,maxCost));
    }
}
