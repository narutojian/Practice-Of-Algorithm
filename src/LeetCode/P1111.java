package LeetCode;

public class P1111 {

    /**
     * 分配括号字符串的嵌套深度
     * 使 A B两个字符串的嵌套深度接近
     * @param seq 给定的括号字符串
     * @return 结果
     */
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        char[] chars = seq.toCharArray();
        int leftParenthesis = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                ans[i] = (leftParenthesis & 1) == 1 ? 0 : 1;
                leftParenthesis--;
            }
            else {
                leftParenthesis++;
                ans[i] = (leftParenthesis & 1) == 1 ? 0 : 1;
            }
        }

        return ans;
    }
}
