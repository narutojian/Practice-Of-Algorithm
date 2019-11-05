package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解决。
 * 退出递归条件为 当digits到了最后以为数字时，将此数字对应的字母依次组成字符串。
 * 递归体，则是每一个数字对应的字母，依次将这些字母作为字符串中的一位，然后递归到下一位。
 */
public class P17 {
    List<String> ans = new ArrayList<>();
    String[] chars = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public void DFS(String temp, String digits, int index) {
        int num = Integer.parseInt(""+digits.charAt(index));
        if (index == digits.length()-1) {
            for (int i = 0; i < chars[num].length(); i++) {
                ans.add(temp+chars[num].charAt(i));
            }
            return;
        }
        for (int i = 0;i< chars[num].length();i++) {
            DFS(temp+chars[num].charAt(i),digits,index+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return ans; // 特判没有数字的digits
        DFS("",digits,0);
        return ans;
    }

    public static void main(String[] args) {
//        String digits = "23";
        String digits = "";
        System.out.println(new P17().letterCombinations(digits));
    }
}
