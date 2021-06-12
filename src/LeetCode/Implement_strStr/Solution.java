package LeetCode.Implement_strStr;

/**
 * 28. Implement strStr()
 */
public class Solution {

    /**
     * 暴力搜索
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (i+j >= haystack.length())
                    return -1;
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }
}
