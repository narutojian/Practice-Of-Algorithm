package LeetCode.find_words_that_can_be_formed_by_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. Find Words That Can Be Formed by Characters
 */
public class Solution {

    /**
     * 哈希表计数
     * @param words 字符串数组
     * @param chars 指定的字符串
     * @return 总长度
     */
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        // 将chars每个字符放入map中
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        A:for (String str : words) {
            if (str.length() > chars.length()) continue;
            Map<Character,Integer> temp = new HashMap<>();
            temp.putAll(map);

            // 判断str的字符是否都在map中
            for (char c : str.toCharArray()) {
                if (!temp.containsKey(c) || temp.get(c) == 0) {
                    continue A;
                } else {
                    temp.put(c,temp.get(c)-1);
                }
            }
            len += str.length();
        }
        return len;
    }

    public static void main(String[] args) {
        Solution h = new Solution();

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

        System.out.println(h.countCharacters(words,chars));
    }
}
