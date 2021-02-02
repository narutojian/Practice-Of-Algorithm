package LeetCode.Longest_Repeating_Character_Replacement;

/**
 * 424. Longest Repeating Character Replacement
 */
public class Solution {

    /**
     * 滑动窗口 双指针
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] upperCase = new int[26];
        int res = 0;
        int start = -1,end;
        for (end = 0; end < n; end++) {
            upperCase[s.charAt(end)-'A']++;
            while (!checkDiff(upperCase,k,end-start)) {
                start++;
                upperCase[s.charAt(start)-'A']--;
            }
            res = Math.max(res,end-start);
        }
        return res;
    }

    /**
     * 检测是否只需要k次操作就可以将长为totalLen的子字符串全部置换为同一个字符
     * @param chars
     * @param k
     * @param totalLen
     * @return
     */
    private boolean checkDiff(int[] chars,int k,int totalLen) {
        for (int i = 0; i < chars.length; i++) {
            if (totalLen-chars[i] <= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        String s = "ABAB";
//        int k = 2;

        String s = "AABABBA";
        int k = 1;

        System.out.println(solution.characterReplacement(s,k));
    }
}
