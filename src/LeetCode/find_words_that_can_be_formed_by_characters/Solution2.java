package LeetCode.find_words_that_can_be_formed_by_characters;

public class Solution2 {
    private int[] map = new int[26];

    /**
     * 用数组计数
     * @param words 字符串数组
     * @param chars 给定的字符串
     * @return 总长度
     */
    public int countCharacters(String[] words, String chars) {
        int len = 0;
        for (char c : chars.toCharArray()) {
            map[c-'a']++;
        }
        for (String str : words) {
            if (str.length() <= chars.length() && IsInDictionary(str)) {
                len += str.length();
            }
        }
        return len;
    }

    private boolean IsInDictionary(String str) {
        int[] temp = new int[26];
        for (char c : str.toCharArray()) {
            temp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] < temp[i]) {
                return false;
            }
        }
        return true;
    }
}
