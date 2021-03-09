package LeetCode.Letter_Combinations_of_a_Phone_Number;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class Solution {
    int n;
    Map<Character,List<Character>> map;
    List<String> res = new ArrayList<>();

    /**
     * 回溯
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if (n == 0)
            return res;
        map = new HashMap<>();
        map.put('2',Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));

        dfs(0,new StringBuilder(),digits);
        return res;
    }

    private void dfs(int start,StringBuilder cur,String digits) {
        if (start == n) {
            res.add(cur.toString());
            return;
        }
        List<Character> temp = map.get(digits.charAt(start));
        for (char c : temp) {
            cur.append(c);
            dfs(start + 1, cur, digits);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
