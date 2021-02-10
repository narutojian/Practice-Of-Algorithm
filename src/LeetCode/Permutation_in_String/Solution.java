package LeetCode.Permutation_in_String;

/**
 * 567. Permutation in String
 */
public class Solution {

    /**
     * 双指针 哈希计数
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int[] mapS1 = new int[26];// 记录s1的字符
        for (int i = 0; i < n1; i++) {
            mapS1[s1.charAt(i)-'a']++;
        }

        int start = 0;
        int end = 0;
        int len;
        int[] mapS2 = new int[26];// 保存s2中长度为n1的子串的字符
        for (;end < s2.length();end++) {
            mapS2[s2.charAt(end)-'a']++;
            len = end-start+1;
            if (len > n1) {
                mapS2[s2.charAt(start)-'a']--;
                start++;
                len--;
            }
            if (len == n1) {
                boolean flag = true;
                for (int i = 0; i < 26; i++) {
                    if (mapS1[i] != mapS2[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
