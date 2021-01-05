package LeetCode.Positions_of_Large_Groups;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 */
public class Solution {

    /**
     * 直接遍历就行 常量使用的个数还可以优化
     * 时间复杂度 O(n) 空间复杂度 O(1)
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new LinkedList<>();
        int count = 1;// 计数
        int curChar = s.charAt(0);// 当前字符
        int start = 0;// 区间起始位置

        for (int i = 1; i < s.length(); i++) {
            if (curChar == s.charAt(i)) {
                count++;
            }
            else {
                // add large group
                if (count > 2) {
                    ans.add(Arrays.asList(start,i-1));
                }
                // 更新
                count = 1;
                start = i;
                curChar = s.charAt(i);
            }
        }
        // the last is large group
        if (count > 2) {
            ans.add(Arrays.asList(start,s.length()-1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String s = "abbxxxxzzy";

//        String s = "abc";

//        String s = "abcdddeeeeaabbbcd";

        String s = "aba";

        List<List<Integer>> ans = solution.largeGroupPositions(s);

        for (List<Integer> i :
                ans) {
            System.out.println(i);
        }
    }
}
