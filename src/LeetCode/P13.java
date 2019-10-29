package LeetCode;

/**
 * 没啥好说的，就是一个map。
 */

import java.util.HashMap;

public class P13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        HashMap<String,Integer> specialMap = new HashMap<>();
        specialMap.put("IV",4);
        specialMap.put("IX",9);
        specialMap.put("XL",40);
        specialMap.put("XC",90);
        specialMap.put("CD",400);
        specialMap.put("CM",900);

        int ans = 0;
        String temp;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1)
                temp = "";
            else temp = s.substring(i,i+2);
            if (specialMap.containsKey(temp)){
                ans += specialMap.get(temp);
                i++;
            }
            else ans += map.get(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "III";
//        String s = "IV";
//        String s = "IX";
//        String s = "LVIII";
        String s = "MCMXCIV";

        System.out.println(new P13().romanToInt(s));
    }
}
