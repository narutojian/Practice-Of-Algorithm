package LeetCode;

public class P28 {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int step = needle.length();
        for (int i = 0; i < haystack.length()-step+1; i++) {
            if (haystack.substring(i,i+step).equals(needle))
                return i;
        }
        return -1;
    }

    /*
    把字符串转成字符数组 然后用双指针法
     */
    public int strStr_2(String haystack, String needle) {
        if (needle.equals("")) return 0;
        char[] hayStackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int step = needleChars.length;
        A: for (int i = 0; i < hayStackChars.length-step+1; i++) {
            for (int j = 0; j < needleChars.length; j++) {
                if (hayStackChars[i+j] != needleChars[j]) continue A;
            }
            return i;
        }
        return -1;
    }
}
