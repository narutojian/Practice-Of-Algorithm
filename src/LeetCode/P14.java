package LeetCode;

/**
 * 字符串
 */
public class P14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < Math.min(ans.length(), strs[i].length()); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) break;
            }
            ans = ans.substring(0,j);
            if (ans.equals(""))
                return "";
        }

        return ans;
    }

    public String longestCommonPrefix_Solution2(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder ans = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans.toString()) != 0){
                ans.deleteCharAt(ans.length()-1);
                if (ans.length() == 0)
                    return "";
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(new P14().longestCommonPrefix(strs));
        System.out.println(new P14().longestCommonPrefix_Solution2(strs));
//        String a = "flower";
//        String b = "flow";
//        String c = "flight";
//        System.out.println(b.indexOf(a));
//        System.out.println(a.indexOf(b));
//        System.out.println(a.indexOf(c));
//        System.out.println(c.indexOf(a));
    }
}
