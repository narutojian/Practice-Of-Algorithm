package LeetCode.short_encoding_of_words;

import java.util.Arrays;
import java.util.HashSet;

public class Solution2 {

    /**
     * 哈希set来清除与某个单词后缀相同的单词
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String i :
                words) {
            for (int j = 1; j < i.length(); j++) {
                set.remove(i.substring(j));
            }
        }

        int ans = 0;
        for (String i :
                set) {
            ans += i.length()+1;
        }
        return ans;
    }
}
