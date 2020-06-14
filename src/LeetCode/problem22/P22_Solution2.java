package LeetCode.problem22;

import java.util.ArrayList;
import java.util.List;

public class P22_Solution2 {

    private int num;
    private int n;
    private char[] data = new char[] {'(',')'};
    private int[] dataOfValue = new int[] {1,-1};
    private int[] numsOfSide = new int[] {0,0};

    /**
     * dfs回溯
     * @param n 给定的括号对
     * @return 返回所有合法的括号组合
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        this.n = n;
        num = 2*n;
        StringBuilder builder = new StringBuilder();
        backTrace(ans,0,builder);
        return ans;
    }

    public void backTrace(List<String> ans, int sum, StringBuilder builder) {
        if (builder.length() == num) {
            ans.add(builder.toString());
            return;
        }
        int temp;
        for (int i = 0; i < data.length; i++) {
            temp = sum + dataOfValue[i];
            if (temp < 0 || numsOfSide[i] == n) continue;
            builder.append(data[i]);
            numsOfSide[i]++;
            backTrace(ans,temp,builder);
            builder.deleteCharAt(builder.length()-1);
            numsOfSide[i]--;
        }
    }

    public static void main(String[] args) {
        P22_Solution2 h = new P22_Solution2();
        List<String> ans = h.generateParenthesis(3);
        for (String i :
                ans) {
            System.out.println(i);
        }
    }
}
