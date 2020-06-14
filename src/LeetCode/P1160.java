package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class P1160 {

    /**
     * 哈希表计数
     * @param words 输入
     * @param chars 输入
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            if (map.containsKey(chars.charAt(i)))
                map.put(chars.charAt(i),map.get(chars.charAt(i))+1);
            else map.put(chars.charAt(i),1);
        }

        A: for (int i = 0; i < words.length; i++) {
            if (words[i].length() > chars.length())
                continue;
            Map<Character,Integer> temp = new HashMap<>();
            temp.putAll(map);
            for (int j = 0; j < words[i].length(); j++) {
                if (!temp.containsKey(words[i].charAt(j)))
                    continue A;
                else {
                    if (temp.get(words[i].charAt(j)) == 0) continue A;
                    else temp.put(words[i].charAt(j),temp.get(words[i].charAt(j)) -1);
                }
            }
            ans += words[i].length();
        }
        return ans;
    }

    public static void main(String[] args) {
        P1160 h = new P1160();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(h.countCharacters(words,chars));
    }
}
