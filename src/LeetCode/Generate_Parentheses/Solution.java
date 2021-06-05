package LeetCode.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */
public class Solution {

    private List<String> res = new ArrayList<>();

    /**
     * 回溯法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder().append('('),n-1,n);
        return res;
    }

    private void dfs(StringBuilder sb,int left,int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        // 此时是无效括号
        if (left > right || left < 0 || right < 0)
            return;
        dfs(new StringBuilder(sb).append('('),left-1,right);
        dfs(new StringBuilder(sb).append(')'),left,right-1);
    }
}
