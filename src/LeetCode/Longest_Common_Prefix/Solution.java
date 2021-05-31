package LeetCode.Longest_Common_Prefix;

/**
 * 14. Longest Common Prefix
 */
public class Solution {

    /**
     * 枚举
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index < res.length() && index < strs[i].length()) {
                if (res.charAt(index) != strs[i].charAt(index))
                    break;
                index++;
            }
            res = res.substring(0,index+1);
        }

        return res;
    }
}
