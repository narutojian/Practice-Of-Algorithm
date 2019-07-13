package LeetCode;

public class P3 {

    /**
     * 滑窗法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int length = 0;

        for (int i = 0; i < chars.length; i++) {

            for (int j = start; j < end; j++) {
                if (chars[j] == chars[i]){
                    start = j+1;
                    break;
                }
            }

            end++;
            if ((end-start) >length)
                length = end - start;
        }
        return length;
    }

    public static void main(String[] args) {

        String s = "dvdf";
        System.out.println(new P3().lengthOfLongestSubstring(s));
    }
}
