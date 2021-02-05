package LeetCode.Get_Equal_Substrings_Within_Budget;

public class Solution2 {
    /**
     * 看到别人的代码
     * 感觉不是太好想 就是有点不符合正常的思路
     * 调式几次 可以稍微理解些了
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int curCost = 0;

        for (int i = 0; i < s.length(); i++) {
            curCost += Math.abs(s.charAt(i)-t.charAt(i));
            // 只在不满足限制条件时 窗口右移一次
            if (curCost > maxCost) {
                curCost -= Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
        }
        // 因为在不满足限制条件时 只移动一次 则表明窗口的大小始终保持在最大值的情况下
        return s.length()-start;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

//        String s = "abcd";
//        String t = "bcdf";
//        int maxCost = 3;

        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;

        System.out.println(solution2.equalSubstring(s,t,maxCost));
    }
}
