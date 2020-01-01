package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P22 {
    char[] chars;

    public List<String> generateParenthesis(int n) {
        chars = new char[2*n];
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) chars[i] = '(';
            else chars[i] = ')';
        }

        List<String> ans = new ArrayList<>();
        return ans;
    }

    public void fullPermutation(List<String> ans, int start) {
        if (start == chars.length -1) {

        }
    }
    public void swap(int i,int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String[] s = {"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
        System.out.println(s.length);
    }
}
