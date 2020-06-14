package LeetCode.problem3;

import java.util.HashSet;
import java.util.Set;

public class P3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int start = 0,end = 0,ans = 0;

        for (; end < chars.length; end++) {
            if (set.add(chars[end])) continue;
            ans = Math.max(ans,end-start);
            while (start < end && chars[start] != chars[end]) {
                set.remove(chars[start]);
                start++;
            }
            start++;
        }
        return Math.max(ans,end - start);
    }

    public static void main(String[] args) {
        P3 h = new P3();

        String s = " ";

        System.out.println(h.lengthOfLongestSubstring(s));
    }
}
