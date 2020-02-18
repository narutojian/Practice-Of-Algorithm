package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 用的是有重复数字的全排列的思想来做的这一题
 * 代码跟其他人比多了很多。。。
 */
public class P22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] nums = new char[2*n];
        for (int i = 0; i < n; i++) {
            nums[i] = '(';
            nums[i+n] = ')';
        }
        fullPermute(ans,nums,0);
        return ans;
    }

    public void fullPermute(List<String> ans,char[] nums,int start) {
        if (start == nums.length-1) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == '(') count++;
                else count--;
                if (count == -1) return;
            }
            ans.add(new String(nums));
            return;
        }

        boolean flag = false;
        for (int i = start; i < nums.length && !flag; i++) {
            if (i == start)
                fullPermute(ans,nums,start+1);
            else {
                while (i < nums.length && nums[i] == nums[start]) i++;
                if (i == nums.length) return;
                if (start == 0 || i == nums.length-1) continue;
                flag = true;
                swap(nums,i,start);
                fullPermute(ans,nums,start+1);
                swap(nums,i,start);
            }
        }
    }

    public void swap(char[] nums,int i,int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        P22 h = new P22();
        List<String> ans = h.generateParenthesis(3);
        for (String i :
                ans) {
            System.out.println(i);
        }
    }
}
