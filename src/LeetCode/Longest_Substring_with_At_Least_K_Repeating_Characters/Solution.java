package LeetCode.Longest_Substring_with_At_Least_K_Repeating_Characters;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */
public class Solution {

    /**
     * 暴力枚举 子字符串的左右边界
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (k == 1) return n;
        int res = 0;

        for (int i = 0; i < n - k+1; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j)-'a']++;
                boolean flag = true;
                for (int l = 0; l < 25; l++) {
                    if (cnt[l] != 0 && cnt[l] < k) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res  = Math.max(res,j-i+1);
                }
            }
        }
        return res;
    }
}
